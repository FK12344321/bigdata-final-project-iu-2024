USE team23_projectdb; 

SET hive.resultset.use.unique.column.names = false;

DROP TABLE IF EXISTS q5_results;
CREATE EXTERNAL TABLE q5_results (
  cancellation_policy VARCHAR(100), 
  count INT,
  avg_number_of_reviews DOUBLE,
  avg_price DOUBLE
) ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',' 
LOCATION 'project/warehouse/q5';

INSERT INTO q5_results 
SELECT cancellation_policy, COUNT(*) as count, AVG(number_of_reviews) as avg_number_of_reviews, AVG(EXP(log_price)) as avg_price
FROM airbnb_part_buck
GROUP BY cancellation_policy;

SELECT * FROM q5_results; 
