USE team23_projectdb; 

SET hive.resultset.use.unique.column.names = false;

DROP TABLE IF EXISTS q3_results;
CREATE EXTERNAL TABLE q3_results (
  property_type VARCHAR(100), 
  avg_price DOUBLE
) ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',' 
LOCATION 'project/warehouse/q3';

INSERT INTO q3_results 
SELECT p.property_type, AVG(EXP(p.log_price)) AS avg_price
FROM airbnb_part_buck p
JOIN (
    SELECT property_type, COUNT(*) AS popularity_count
    FROM airbnb_part_buck
    GROUP BY property_type
    ORDER BY popularity_count DESC
    LIMIT 10
) AS top_types ON p.property_type = top_types.property_type
GROUP BY p.property_type
ORDER BY avg_price DESC;

SELECT * FROM q3_results; 
