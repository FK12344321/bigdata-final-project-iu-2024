USE team23_projectdb; 

SET hive.resultset.use.unique.column.names = false;

DROP TABLE IF EXISTS q4_results;
CREATE EXTERNAL TABLE q4_results (
  host_identity_verified BOOLEAN, 
  count INT,
  avg_number_of_reviews DOUBLE
) ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',' 
LOCATION 'project/warehouse/q4';

INSERT INTO q4_results 

SELECT host_identity_verified, COUNT(*) as count, AVG(number_of_reviews) as avg_number_of_reviews
FROM airbnb_part_buck
GROUP BY host_identity_verified;

SELECT * FROM q4_results;
