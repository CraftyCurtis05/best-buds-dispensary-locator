-- **************************************************************
-- Best Buds
-- Creates the tables used by the application
-- **************************************************************

BEGIN TRANSACTION;

-- Remove existing tables
DROP TABLE IF EXISTS
    user_drops,
    drops,
    password_reset_tokens,
    saved_dispensaries,
    profile_images,
    profiles,
    profile,
    image,
    users;

-- Users
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(254) NOT NULL UNIQUE,
    password_hash VARCHAR(200) NOT NULL,
    role VARCHAR(50) NOT NULL,
    age_confirmed BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE password_reset_tokens (
    token_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    token_hash VARCHAR(64) NOT NULL UNIQUE,
    expires_at TIMESTAMP NOT NULL,
    used BOOLEAN NOT NULL DEFAULT FALSE,

    CONSTRAINT fk_password_reset_tokens_users
        FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE
);

-- Profiles
CREATE TABLE profiles (
    profile_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    birthday DATE,
    address_line_1 VARCHAR(150),
    address_line_2 VARCHAR(100),
    city VARCHAR(100),
    state_abbr VARCHAR(2),
    zipcode VARCHAR(10),

    CONSTRAINT fk_profiles_users
        FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE
);

-- Profile Images
CREATE TABLE profile_images (
    image_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    image_data BYTEA NOT NULL,
    content_type VARCHAR(50) NOT NULL,

    CONSTRAINT fk_profile_images_users
        FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE
);

-- Saved Dispensaries
CREATE TABLE saved_dispensaries (
    saved_dispensary_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    yelp_business_id VARCHAR(100) NOT NULL,
    name VARCHAR(150) NOT NULL,
    image_url TEXT,
    address VARCHAR(200),
    city VARCHAR(100),
    state_abbr VARCHAR(2),
    zipcode VARCHAR(10),
    latitude DECIMAL(9, 6),
    longitude DECIMAL(9, 6),
    rating DECIMAL(2, 1),
    saved_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT uq_saved_dispensaries_user_business
        UNIQUE (user_id, yelp_business_id),

    CONSTRAINT fk_saved_dispensaries_users
        FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE
);

-- Drops
CREATE TABLE drops (
    drop_id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(250) NOT NULL,
    rarity VARCHAR(20) NOT NULL,
    category VARCHAR(30) NOT NULL,
    is_secret BOOLEAN NOT NULL DEFAULT FALSE
);

-- User Drops
CREATE TABLE user_drops (
    user_drop_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    drop_id INT NOT NULL,
    unlocked_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT uq_user_drops_user_drop
        UNIQUE (user_id, drop_id),

    CONSTRAINT fk_user_drops_users
        FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_user_drops_drops
        FOREIGN KEY (drop_id)
        REFERENCES drops (drop_id)
        ON DELETE CASCADE
);

COMMIT TRANSACTION;