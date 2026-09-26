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
-- Best Buds Drops
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
        'FIRST_CONTACT',
        'First Contact',
        'You viewed your first dispensary.',
        'STANDARD',
        'EXPLORE',
        FALSE
    ),
    (
        'NIGHT_OWL',
        'Night Owl',
        'You explored Best Buds late at night.',
        'DISCOVERY',
        'EXPLORE',
        FALSE
    ),
    (
        'OFF_THE_MAP',
        'Off the Map',
        'You explored outside your home area.',
        'DISCOVERY',
        'EXPLORE',
        FALSE
    ),
    (
        'EXPLORER',
        'Explorer',
        'You explored multiple areas of Best Buds.',
        'MILESTONE',
        'EXPLORE',
        FALSE
    ),
    (
        'CURATOR',
        'Curator',
        'You saved 10 dispensaries.',
        'MILESTONE',
        'STASH',
        FALSE
    ),
    (
        'STASHED',
        'Stashed',
        'You earned your first Drop.',
        'STANDARD',
        'STASH',
        FALSE
    ),
    (
        'DEEP_DIVE',
        'Deep Dive',
        'You explored multiple education articles.',
        'STANDARD',
        'LEARN',
        FALSE
    ),
    (
        'WELL_INFORMED',
        'Well Informed',
        'You explored several education categories.',
        'DISCOVERY',
        'LEARN',
        FALSE
    ),
    (
        'KNOW_YOUR_BUDS',
        'Know Your Buds',
        'You explored cannabis and product education.',
        'MILESTONE',
        'LEARN',
        FALSE
    ),
    (
        'READ_THE_LABEL',
        'Read the Label',
        'You explored product and label information.',
        'DISCOVERY',
        'LEARN',
        FALSE
    ),
    (
        'SAFETY_FIRST',
        'Safety First',
        'You explored your safety resources.',
        'STANDARD',
        'SAFETY',
        FALSE
    ),
    (
        'CLEAR_HEAD',
        'Clear Head',
        'You completed several safety topics.',
        'MILESTONE',
        'SAFETY',
        FALSE
    ),
    (
        'UNDISCOVERED',
        'Undiscovered',
        'Some things only appear after everyone else goes home.',
        'HIDDEN',
        'SPECIAL',
        TRUE
    ),
    (
        'THE_REGULAR',
        'The Regular',
        'You returned to Best Buds over multiple days.',
        'MILESTONE',
        'SPECIAL',
        FALSE
    ),
    (
        'COMPLETIONIST',
        'Completionist',
        'You reached a major exploration milestone.',
        'MILESTONE',
        'SPECIAL',
        FALSE
    ),
    (
        'THE_WHOLE_PICTURE',
        'The Whole Picture',
        'You explored across education, safety, and products.',
        'MILESTONE',
        'SPECIAL',
        FALSE
    ),
    (
        'LOCAL_EXPLORE',
        'Local Explore',
        'You explored 5 dispensaries near home.',
        'MILESTONE',
        'EXPLORE',
        FALSE
    ),
    (
        'BIRTHDAY_BUD',
        'Birthday Bud',
        'Happy Birthday! You celebrated another trip around the sun.',
        'SPECIAL',
        'CELEBRATE',
        FALSE
    );

COMMIT TRANSACTION;