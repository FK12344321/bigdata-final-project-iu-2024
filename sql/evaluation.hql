USE team23_projectdb; 

SET hive.resultset.use.unique.column.names = false;

DROP TABLE IF EXISTS evaluation;
CREATE EXTERNAL TABLE evaluation (
    model STRING,
    RMSE DOUBLE,
    R2 DOUBLE
) 
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
WITH SERDEPROPERTIES (
   "separatorChar" = ",",
   "quoteChar"     = "\"")
LOCATION 'project/output/evaluation.csv'
tblproperties ("skip.header.line.count"="1");

SELECT * FROM evaluation; 