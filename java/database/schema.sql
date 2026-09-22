-- **************************************************************
-- Best Buds
-- Creates the tables used by the application
-- **************************************************************

BEGIN TRANSACTION;

-- Remove existing tables
DROP TABLE IF EXISTS favorites, profile, image, users;

-- Users
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(200) NOT NULL,
    role VARCHAR(50) NOT NULL,
    age_confirmed BOOLEAN NOT NULL DEFAULT FALSE
);

-- Profiles
CREATE TABLE profile (
    profile_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_month VARCHAR(9) NOT NULL,
    birth_day INT NOT NULL,
    birth_year INT NOT NULL,
    address1 VARCHAR(150) NOT NULL,
    address2 VARCHAR(50),
    city VARCHAR(100) NOT NULL,
    state_abbr VARCHAR(2) NOT NULL,
    zipcode VARCHAR(5) NOT NULL,
    is_form_submitted BOOLEAN DEFAULT FALSE,

    CONSTRAINT fk_profile_users
        FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE
);

-- Profile Images
CREATE TABLE image (
    image_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    image_name VARCHAR(100),
    image BYTEA,

    CONSTRAINT fk_image_users
        FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE
);

COMMIT TRANSACTION;
