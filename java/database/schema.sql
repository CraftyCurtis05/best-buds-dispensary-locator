-- **************************************************************
-- Best Buds
-- Creates the tables used by the application
-- **************************************************************

BEGIN TRANSACTION;

-- Remove existing tables
DROP TABLE IF EXISTS
    password_reset_tokens,
    favorites,
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

COMMIT TRANSACTION;
