DROP DATABASE IF EXISTS team23_projectdb CASCADE;
CREATE DATABASE team23_projectdb LOCATION "project/hive/warehouse";
USE team23_projectdb;
CREATE EXTERNAL TABLE airbnb_houses_raw STORED AS AVRO LOCATION 'project/warehouse/airbnb_houses'
TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/airbnb_houses.avsc');
SELECT COUNT(*) FROM airbnb_houses_raw; 

CREATE EXTERNAL TABLE airbnb_houses (
  id INT, 
  log_price DOUBLE, 
  property_type STRING, 
  room_type STRING, 
  amenities STRING, 
  accommodates INT, 
  bathrooms FLOAT, 
  bed_type STRING, 
  cancellation_policy STRING, 
  cleaning_fee BOOLEAN, 
  city STRING, 
  description STRING, 
  first_review DATE, 
  host_has_profile_pic BOOLEAN, 
  host_identity_verified BOOLEAN, 
  host_response_rate FLOAT, 
  host_since DATE, 
  instant_bookable BOOLEAN, 
  last_review DATE, 
  latitude DOUBLE, 
  longitude DOUBLE, 
  name STRING, 
  neighbourhood STRING, 
  number_of_reviews INT, 
  review_scores_rating FLOAT, 
  thumbnail_url STRING, 
  zipcode STRING, 
  bedrooms FLOAT, 
  beds FLOAT
) STORED AS AVRO LOCATION 'project/warehouse/airbnb_houses_preprocessed'
TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

INSERT INTO airbnb_houses 
SELECT id, CAST(log_price AS DOUBLE) AS log_price, property_type, room_type, 
amenities, accommodates, CAST(bathrooms AS FLOAT) AS bathrooms, bed_type, 
cancellation_policy, cleaning_fee, city, description, 
from_unixtime(CAST(first_review/1000 AS BIGINT), 'yyyy-MM-dd HH:mm:ss.SSS') AS first_review,
host_has_profile_pic, host_identity_verified, CAST(SUBSTRING(host_response_rate, 1, length(host_response_rate) - 1) AS FLOAT) AS host_response_rate, 
from_unixtime(CAST(host_since/1000 AS BIGINT), 'yyyy-MM-dd HH:mm:ss.SSS') AS host_since,
instant_bookable, from_unixtime(CAST(last_review/1000 AS BIGINT), 'yyyy-MM-dd HH:mm:ss.SSS') AS last_review,
CAST(latitude AS DOUBLE) AS latitude, CAST(longitude AS DOUBLE) AS longitude, name, neighbourhood, 
number_of_reviews, CAST(review_scores_rating AS FLOAT) AS review_scores_rating, thumbnail_url, 
zipcode, CAST(bedrooms AS FLOAT) AS bedrooms, CAST(beds AS FLOAT) AS beds 
FROM airbnb_houses_raw; 

DROP TABLE airbnb_houses_raw;

DROP TABLE airbnb_part_buck;

CREATE TABLE airbnb_part_buck (
  id INT,
  log_price DOUBLE,
  property_type STRING,
  room_type STRING,
  amenities STRING,
  accommodates INT,
  bathrooms FLOAT,
  bed_type STRING,
  cancellation_policy STRING,
  cleaning_fee BOOLEAN,
  city STRING,
  description STRING,
  first_review DATE,
  host_has_profile_pic BOOLEAN,
  host_identity_verified BOOLEAN,
  host_response_rate FLOAT,
  host_since DATE,
  instant_bookable BOOLEAN,
  last_review DATE,
  latitude DOUBLE,
  longitude DOUBLE,
  name STRING,
  neighbourhood STRING,
  number_of_reviews INT,
  review_scores_rating FLOAT,
  thumbnail_url STRING,
  zipcode STRING,
  beds FLOAT
)
PARTITIONED BY (bedrooms int)
CLUSTERED BY (id) into 9 buckets
STORED AS AVRO LOCATION 'project/warehouse/airbnb_houses_part_buck'
TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

INSERT INTO airbnb_part_buck
SELECT id, log_price, property_type, room_type, amenities, accommodates, 
bathrooms, bed_type, cancellation_policy, cleaning_fee, city, description, 
first_review, host_has_profile_pic, host_identity_verified, host_response_rate, 
host_since, instant_bookable, last_review, latitude, longitude, name, neighbourhood, 
number_of_reviews, review_scores_rating, thumbnail_url, zipcode, beds, bedrooms
FROM airbnb_houses; 

DROP TABLE airbnb_houses; 
