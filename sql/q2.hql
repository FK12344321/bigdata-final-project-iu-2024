USE team23_projectdb; 

SET hive.resultset.use.unique.column.names = false;

DROP TABLE IF EXISTS q2_results;
CREATE EXTERNAL TABLE q2_results (
  host_response_rate FLOAT, 
  review_scores_rating INT
) ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',' 
LOCATION 'project/warehouse/q2';

INSERT INTO q2_results 
SELECT AVG(host_response_rate) AS host_response_rate, CAST((review_scores_rating) AS INT) AS review_scores_rating
FROM airbnb_part_buck
WHERE host_response_rate IS NOT NULL AND review_scores_rating IS NOT NULL
GROUP BY review_scores_rating 
HAVING COUNT(host_response_rate) > 100
ORDER BY review_scores_rating;

SELECT * FROM q2_results; 
