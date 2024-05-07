USE team23_projectdb; 

SET hive.resultset.use.unique.column.names = false;

DROP TABLE IF EXISTS model1_predictions;
CREATE EXTERNAL TABLE model1_predictions (
  label DOUBLE, 
  prediction DOUBLE
) ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',' 
STORED AS TEXTFILE
LOCATION 'project/output/model1_predictions.csv'
tblproperties ("skip.header.line.count"="1");

SELECT * FROM model1_predictions LIMIT 5; 