USE team23_projectdb; 

SET hive.resultset.use.unique.column.names = false;

DROP TABLE IF EXISTS q1_results;
CREATE EXTERNAL TABLE q1_results (
  city VARCHAR(100), 
  avg_price DOUBLE
) ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',' 
LOCATION 'project/warehouse/q1';

INSERT INTO q1_results 
SELECT city, AVG(EXP(log_price)) AS avg_price 
FROM airbnb_part_buck
GROUP BY city 
ORDER BY avg_price DESC
LIMIT 15; 

SELECT * FROM q1_results; 
