'''
This module is the entire implementation of Stage 3
'''

import math
import os
import numpy as np
from pyspark.sql import SparkSession
import pyspark.sql.functions as F
from pyspark.ml import Pipeline
from pyspark.ml.feature import StringIndexer, OneHotEncoder, VectorAssembler
from pyspark import keyword_only
from pyspark.ml import Transformer
from pyspark.ml.param.shared import HasInputCol, HasOutputCol, HasInputCols
from pyspark.ml.util import DefaultParamsReadable, DefaultParamsWritable
from pyspark.sql import DataFrame
from pyspark.ml.linalg import Vectors, VectorUDT
from pyspark.ml.feature import PCA, Word2Vec, RegexTokenizer
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator
from pyspark.ml.evaluation import RegressionEvaluator
from pyspark.ml.regression import GBTRegressor, LinearRegression


# Add here your team number teamx
TEAM = "team23"

# location of your Hive database in HDFS
WAREHOUSE = "project/hive/warehouse"

print("Creating spark session")
spark = SparkSession.builder\
        .appName(f"{TEAM} - spark ML")\
        .master("yarn")\
        .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")\
        .config("spark.sql.warehouse.dir", WAREHOUSE)\
        .config("spark.sql.avro.compression.codec", "snappy")\
        .config("spark.executor.instances", 5)\
        .enableHiveSupport()\
        .getOrCreate()

sc = spark.sparkContext

spark.sql("USE team23_projectdb;")

# We will use the following features
# Excluded 'thumbnail_url' and 'id' because it has no valuable information to extract
# Exclude? host-related attributes since they contain little information about listing itself
# Excluded 'first_review', 'host_response_rate', 'last_review' 'review_scores_rating'
# because of large amount of Null values
features = ['property_type', 'room_type', 'amenities', 'accommodates', 'bathrooms',\
            'bed_type', 'cancellation_policy', 'cleaning_fee', 'city', 'description',\
            'host_has_profile_pic', 'host_identity_verified','host_since',\
            'instant_bookable', 'latitude', 'longitude', 'name', 'neighbourhood', \
            'number_of_reviews', 'zipcode', 'beds', 'bedrooms']

# The output/target of our model
LABEL = 'log_price'

print("Reading database")
airbnb = spark.read.format("avro").table('team23_projectdb.airbnb_part_buck')

# drop rows with missing values
df2 = airbnb.select(features + [LABEL]).na.drop()
df2 = df2.withColumnRenamed('log_price', 'label')


categoricalCols = ['property_type', 'room_type', 'bed_type', 'cancellation_policy',
                   'city', 'neighbourhood', 'zipcode']
textCols = ['name', 'description']
dateCols = ['host_since']
booleanCols = ['cleaning_fee', 'host_has_profile_pic', 'host_identity_verified', 'instant_bookable']
numericalCols = ['accommodates', 'bathrooms', 'number_of_reviews', 'beds', 'bedrooms']
geoCols = [['latitude', 'longitude']]
jsonCols = ['amenities']

# cast all boolean and numerical columns to the same type
numericalCols += booleanCols
for c in numericalCols:
    df2 = df2.withColumn(c, df2[c].cast('float'))


DAY_PERIOD = 31
MONTH_PERIOD = 12


class YMDTransformer(Transformer, HasInputCol, HasOutputCol,
                     DefaultParamsReadable, DefaultParamsWritable):
    '''
    Custom transformer for date features in YYYY-MM-DD format
    '''

    @keyword_only
    def __init__(self, inputCol: str = "input", outputCol: str = "output"):
        super().__init__()
        self._setDefault(inputCol=inputCol, outputCol=outputCol)
        self.set_params(input_col=inputCol, output_col=outputCol)

    @keyword_only
    def set_params(self, input_col: str = "input", output_col: str = "output"):
        '''
        Parameters:
        input_col (str): The name to assign to the input column.
        output_col (str): The name to assign to the output column.

        Returns:
        object: The instance of the class with updated column names.
        '''

        return self._set(inputCol=input_col, outputCol=output_col)

    def _transform(self, dataset: DataFrame):
        input_col = self.getInputCol()
        output_col = self.getOutputCol()

        # split the data and cast to float
        input_col = F.split(dataset[input_col], '-').cast("array<float>")

        # apply transform to day
        d_sin = F.sin(2 * math.pi * F.element_at(input_col, 3) / DAY_PERIOD)
        d_cos = F.cos(2 * math.pi * F.element_at(input_col, 3) / DAY_PERIOD)

        # apply transform to month
        m_sin = F.sin(2 * math.pi * F.element_at(input_col, 2) / MONTH_PERIOD)
        m_cos = F.cos(2 * math.pi * F.element_at(input_col, 2) / MONTH_PERIOD)

        # year remains as is
        year = F.element_at(input_col, 1)

        # pack everything into a vector for VectorAssembler
        atov = F.udf(Vectors.dense, VectorUDT())
        res = F.array(d_sin, d_cos, m_sin, m_cos, year)
        res = atov(res)

        return dataset.withColumn(output_col, res)


class ECEFTransformer(Transformer, HasInputCols, HasOutputCol,
                      DefaultParamsReadable, DefaultParamsWritable):
    '''
    Custom transformer for geospartial features
    '''

    @keyword_only
    def __init__(self, inputCols: str = "input", outputCol: str = "output"):
        super().__init__()
        self._setDefault(inputCols=inputCols, outputCol=outputCol)
        self.set_params(input_cols=inputCols, output_col=outputCol)

    @keyword_only
    def set_params(self, input_cols: str = "input", output_col: str = "output"):
        '''
        Parameters:
        input_col (str): The name to assign to the input column.
        output_col (str): The name to assign to the output column.

        Returns:
        object: The instance of the class with updated column names.
        '''

        return self._set(inputCols=input_cols, outputCol=output_col)

    def _transform(self, dataset: DataFrame):
        input_cols = self.getInputCols()
        output_col = self.getOutputCol()

        semi_major_axis = 6378137.0               # WGS-84 semi-major axis
        eccentr_squared = 6.6943799901377997e-3  # WGS-84 first eccentricity squared

        lat = dataset[input_cols[0]]
        lon = dataset[input_cols[1]]

        radial_distance = semi_major_axis / F.sqrt(1 - eccentr_squared * F.sin(lat) * F.sin(lat))
        ecef_x = radial_distance * F.cos(lat) * F.cos(lon)    # ECEF x
        ecef_y = radial_distance * F.cos(lat) * F.sin(lon)    # ECEF y
        ecef_z = (radial_distance * (1 - eccentr_squared)) * F.sin(lat)    # ECEF z

        # pack everything into a vector for VectorAssembler
        atov = F.udf(Vectors.dense, VectorUDT())
        res = F.array(ecef_x, ecef_y, ecef_z)
        res = atov(res)

        return dataset.withColumn(output_col, res)


print("Preprocessing data")
ymd_transformers = [YMDTransformer(inputCol=c, outputCol=f"{c}_transformed")
                    for c in dateCols]
ecef_transformers = [ECEFTransformer(inputCols=c, outputCol=f"{c}_transformed")
                     for c in geoCols]


# Tokenize textual features by words
tokenizers = [RegexTokenizer(inputCol=c, outputCol=f"{c}_tokens", pattern=" ")
              for c in textCols]
tokenizers += [RegexTokenizer(inputCol=c, outputCol=f"{c}_tokens", pattern="[\",{}]+")
               for c in jsonCols]

# Vectorize them
vectorizers = [Word2Vec(vectorSize=50, seed=42, minCount=1, inputCol=tokenizer.getOutputCol(),
                        outputCol=f"{tokenizer.getOutputCol()}_vectorized")
               for tokenizer in tokenizers]

# Create String indexer to assign index for the string fields
# where each unique string will get a unique index
# String Indexer is required as an input for One-Hot Encoder
# We set the case as `skip` for any string out of the input strings
indexers = [StringIndexer(inputCol=c, outputCol=f"{c}_indexed").setHandleInvalid("skip")
            for c in categoricalCols]

# Encode the strings using One Hot encoding
# default setting: dropLast=True ==> For example with 5 categories,
# an input value of 2.0 would map to an output vector of [0.0, 0.0, 1.0, 0.0].
# The last category is not included by default (configurable via dropLast),
# because it makes the vector entries sum up to one, and hence linearly dependent.
# So an input value of 4.0 maps to [0.0, 0.0, 0.0, 0.0].
encoders = [OneHotEncoder(inputCol=indexer.getOutputCol(),
                          outputCol=f"{indexer.getOutputCol()}_encoded")
            for indexer in indexers]

# This will concatenate the input cols into a single column.
assembler = VectorAssembler(inputCols=
                            [encoder.getOutputCol() for encoder in encoders] +
                            [vectorizer.getOutputCol() for vectorizer in vectorizers] +
                            [ymd.getOutputCol() for ymd in ymd_transformers] +
                            [ecef.getOutputCol() for ecef in ecef_transformers] +
                            numericalCols, outputCol="features")

# Apply PCA to reduce dimetionalty and reduce computation time
pca = PCA(k=200, inputCol='features', outputCol='components')

# You can create a pipeline to use only a single fit and transform on the data.
pipeline = Pipeline(stages=ymd_transformers + ecef_transformers + tokenizers +
                    vectorizers + indexers + encoders + [assembler] + [pca])


# Fit the pipeline ==> This will call the fit functions for all transformers if exist
model = pipeline.fit(df2)
# Fit the pipeline ==> This will call the transform functions for all transformers
data = model.transform(df2)

# We delete all features and keep only the features and label columns
transformed = data.select(["components", "label"])
transformed = transformed.withColumnRenamed('components', 'features')

#  split the data into 60% training and 40% test (it is not stratified)
(train_data, test_data) = transformed.randomSplit([0.6, 0.4], seed=10)


# replaced coalesce(1) with repartition(1) to fix OoM issue
def run(command):
    '''
    Execute a shell command and return its output.

    Parameters:
    command (str): The shell command to be executed.

    Returns:
    str: The output from the shell command as a string.
    '''

    return os.popen(command).read()


print("Saving test and train splits")
train_data.select("features", "label")\
    .repartition(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/train")

# Run it from root directory of the repository
run("hdfs dfs -cat project/data/train/*.json > data/train.json")

test_data.select("features", "label")\
    .repartition(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/test")

# Run it from root directory of the repository
run("hdfs dfs -cat project/data/test/*.json > data/test.json")


# Create Linear Regression Model
lr = LinearRegression()

# Fit the data to the pipeline stages
model_lr = lr.fit(train_data)

predictions = model_lr.transform(test_data)


# Evaluate the performance of the model
evaluator1_rmse = RegressionEvaluator(labelCol="label", predictionCol="prediction",
                                      metricName="rmse")
evaluator1_r2 = RegressionEvaluator(labelCol="label", predictionCol="prediction",
                                    metricName="r2")

rmse = evaluator1_rmse.evaluate(predictions)
r2 = evaluator1_r2.evaluate(predictions)

print("# Base LinearRegression model")
print(f"Root Mean Squared Error (RMSE) on test data = {rmse}")
print(f"R^2 on test data = {r2}")
print()


print("Running Grid Search for model 1. This would take some time.")
grid = ParamGridBuilder()
grid = grid.addGrid(
                    model_lr.aggregationDepth, [2, 3, 4])\
                    .addGrid(model_lr.regParam, np.logspace(1e-3, 1e-1)
                    )\
                    .build()

cv = CrossValidator(estimator=lr,
                    estimatorParamMaps=grid,
                    evaluator=evaluator1_rmse,
                    parallelism=5,
                    numFolds=3)

cvModel = cv.fit(train_data)
model1 = cvModel.bestModel

print("Saving model 1 and its predictions")
model1.write().overwrite().save("project/models/model1")

# Run it from root directory of the repository
run("hdfs dfs -get project/models/model1 models/model1")

predictions = model1.transform(test_data)


predictions.select("label", "prediction")\
    .repartition(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/model1_predictions.csv")

# Run it from root directory of the repository
run("hdfs dfs -cat project/output/model1_predictions.csv/*.csv > output/model1_predictions.csv")


# Evaluate the performance of the model
evaluator1_rmse = RegressionEvaluator(labelCol="label", predictionCol="prediction",
                                      metricName="rmse")
evaluator1_r2 = RegressionEvaluator(labelCol="label", predictionCol="prediction",
                                    metricName="r2")

rmse1 = evaluator1_rmse.evaluate(predictions)
r21 = evaluator1_r2.evaluate(predictions)

print("# Best LinearRegression model")
print(f"Root Mean Squared Error (RMSE) on test data = {rmse1}")
print(f"R^2 on test data = {r21}")
print()


# Create Linear Regression Model
gbt = GBTRegressor()

# Fit the data to the pipeline stages
model_gbt = gbt.fit(train_data)
predictions = model_gbt.transform(test_data)


# Evaluate the performance of the model
evaluator2_rmse = RegressionEvaluator(labelCol="label", predictionCol="prediction",
                                      metricName="rmse")
evaluator2_r2 = RegressionEvaluator(labelCol="label", predictionCol="prediction",
                                    metricName="r2")

rmse2 = evaluator2_rmse.evaluate(predictions)
r22 = evaluator2_r2.evaluate(predictions)

print("# Base GBTRegressor model")
print(f"Root Mean Squared Error (RMSE) on test data = {rmse2}")
print(f"R^2 on test data = {r22}")
print()


print("Running Grid Search for model 2. This would take a lot of time.")
grid = ParamGridBuilder()
grid = grid.addGrid(model_gbt.maxDepth, [2, 5]).addGrid(model_gbt.lossType,
                                                        ['squared', 'absolute']).build()

cv = CrossValidator(estimator=gbt,
                    estimatorParamMaps=grid,
                    evaluator=evaluator2_rmse,
                    parallelism=5,
                    numFolds=2)

cvModel = cv.fit(train_data)
model2 = cvModel.bestModel

print("Saving model 2 and its predictions")
model2.write().overwrite().save("project/models/model2")

# Run it from root directory of the repository
run("hdfs dfs -get project/models/model2 models/model2")

predictions = model2.transform(test_data)
predictions.select("label", "prediction")\
    .repartition(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/model2_predictions.csv")

# Run it from root directory of the repository
run("hdfs dfs -cat project/output/model2_predictions.csv/*.csv > output/model2_predictions.csv")


# Evaluate the performance of the model
evaluator2_rmse = RegressionEvaluator(labelCol="label", predictionCol="prediction",
                                      metricName="rmse")
evaluator2_r2 = RegressionEvaluator(labelCol="label", predictionCol="prediction",
                                    metricName="r2")

rmse2 = evaluator2_rmse.evaluate(predictions)
r22 = evaluator2_r2.evaluate(predictions)

print("# Best GBTRegressor model")
print(f"Root Mean Squared Error (RMSE) on test data = {rmse2}")
print(f"R^2 on test data = {r22}")
print()


models = [[str(model1), rmse1, r21], [str(model2), rmse2, r22]]

print("# Comparsion")
df = spark.createDataFrame(models, ["model", "RMSE", "R2"])
df.show(truncate=False)

df.repartition(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/evaluation.csv")

# Run it from root directory of the repository
run("hdfs dfs -cat project/output/evaluation.csv/*.csv > output/evaluation.csv")
