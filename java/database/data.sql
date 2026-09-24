-- **************************************************************
-- Best Buds
-- Adds development data to the database
-- cd /java ./database/create.sh
-- **************************************************************

BEGIN TRANSACTION;

-- **************************************************************
-- Development Users
--
-- All development accounts use:
-- Password123!
-- **************************************************************


-- USER1
-- Primary application testing account
-- Complete Columbus profile with a normal non-today birthday
INSERT INTO users (
    username,
    email,
    password_hash,
    role,
    age_confirmed
)
VALUES (
    'user1',
    'user1@bestbuds.local',
    '$2a$10$waXw2trDZphO0Tk64oqc4eDikyzXqPxcwGbhlCSWvZBzbljqvBqd6',
    'ROLE_USER',
    TRUE
);


-- USER2
-- Secondary account for cross-user and ownership testing
-- Uses a different Columbus-area profile
INSERT INTO users (
    username,
    email,
    password_hash,
    role,
    age_confirmed
)
VALUES (
    'user2',
    'user2@bestbuds.local',
    '$2a$10$waXw2trDZphO0Tk64oqc4eDikyzXqPxcwGbhlCSWvZBzbljqvBqd6',
    'ROLE_USER',
    TRUE
);


-- NEW_USER
-- Onboarding test account
-- Intentionally has no profile row
INSERT INTO users (
    username,
    email,
    password_hash,
    role,
    age_confirmed
)
VALUES (
    'newuser',
    'newuser@bestbuds.local',
    '$2a$10$waXw2trDZphO0Tk64oqc4eDikyzXqPxcwGbhlCSWvZBzbljqvBqd6',
    'ROLE_USER',
    FALSE
);


-- ADMIN
-- Administrative and security testing account
-- Complete profile
INSERT INTO users (
    username,
    email,
    password_hash,
    role,
    age_confirmed
)
VALUES (
    'admin',
    'admin@bestbuds.local',
    '$2a$10$waXw2trDZphO0Tk64oqc4eDikyzXqPxcwGbhlCSWvZBzbljqvBqd6',
    'ROLE_ADMIN',
    TRUE
);


-- **************************************************************
-- Development Profiles
-- **************************************************************


-- USER1 PROFILE
-- Main Columbus profile used for normal application testing
INSERT INTO profiles (
    user_id,
    first_name,
    last_name,
    birthday,
    address_line_1,
    address_line_2,
    city,
    state_abbr,
    zipcode
)
VALUES (
    (SELECT user_id FROM users WHERE username = 'user1'),
    'User',
    'One',
    '1990-05-15',
    '123 Main Street',
    '',
    'Columbus',
    'OH',
    '43215'
);


-- USER2 PROFILE
-- Different Columbus-area profile used for cross-user testing
INSERT INTO profiles (
    user_id,
    first_name,
    last_name,
    birthday,
    address_line_1,
    address_line_2,
    city,
    state_abbr,
    zipcode
)
VALUES (
    (SELECT user_id FROM users WHERE username = 'user2'),
    'User',
    'Two',
    '1992-08-10',
    '456 High Street',
    '',
    'Worthington',
    'OH',
    '43085'
);


-- ADMIN PROFILE
-- Complete profile for administrative account testing
INSERT INTO profiles (
    user_id,
    first_name,
    last_name,
    birthday,
    address_line_1,
    address_line_2,
    city,
    state_abbr,
    zipcode
)
VALUES (
    (SELECT user_id FROM users WHERE username = 'admin'),
    'Best Buds',
    'Admin',
    '1985-03-20',
    '789 Broad Street',
    '',
    'Columbus',
    'OH',
    '43228'
);


-- **************************************************************
-- Best Buds Collectibles
-- **************************************************************

INSERT INTO collectibles (
    code,
    name,
    description,
    rarity,
    category,
    is_secret
)
VALUES
    (
        'BIRTHDAY_BUD',
        'Birthday Bud',
        'A little something from your Best Buds. Happy birthday!',
        'SPECIAL',
        'BIRTHDAY',
        FALSE
    ),
    (
        'TRAIL_BLAZER',
        'Trail Blazer',
        'There is always another trail to blaze.',
        'COMMON',
        'EXPLORATION',
        FALSE
    ),
    (
        'BUD_KEEPER',
        'Bud Keeper',
        'You know a good bud when you find one.',
        'COMMON',
        'COLLECTION',
        FALSE
    ),
    (
        'GOLDEN_BUD',
        'Golden Bud',
        'Some things are worth searching for.',
        'RARE',
        'SECRET',
        TRUE
    );

COMMIT TRANSACTION;