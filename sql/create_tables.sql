START TRANSACTION;

DROP TABLE IF EXISTS airbnb_houses; 
CREATE TABLE  airbnb_houses (
    id INTEGER PRIMARY KEY,
    log_price NUMERIC,
    property_type VARCHAR(255),
    room_type VARCHAR(255),
    amenities TEXT,
    accommodates INTEGER,
    bathrooms NUMERIC,
    bed_type VARCHAR(100),
    cancellation_policy VARCHAR(100),
    cleaning_fee BOOLEAN,
    city VARCHAR(255),
    description TEXT,
    first_review DATE,
    host_has_profile_pic BOOLEAN,
    host_identity_verified BOOLEAN,
    host_response_rate VARCHAR(100),
    host_since DATE,
    instant_bookable BOOLEAN,
    last_review DATE,
    latitude NUMERIC,
    longitude NUMERIC,
    name VARCHAR(255),
    neighbourhood VARCHAR(255),
    number_of_reviews INTEGER,
    review_scores_rating NUMERIC,
    thumbnail_url TEXT,
    zipcode VARCHAR(30),
    bedrooms NUMERIC,
    beds NUMERIC
);

COMMIT;
