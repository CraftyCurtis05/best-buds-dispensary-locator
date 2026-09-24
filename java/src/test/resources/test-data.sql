BEGIN TRANSACTION;

-- **************************************************************
-- Test Users
-- **************************************************************

-- USER1
-- Complete user used for normal DAO testing
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
    'password123',
    'ROLE_USER',
    FALSE
);


-- USER2
-- Secondary user used for ownership and cross-user testing
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
    'password456',
    'ROLE_USER',
    FALSE
);


-- USER3
-- Unconfirmed user used for age confirmation and security testing
INSERT INTO users (
    username,
    email,
    password_hash,
    role,
    age_confirmed
)
VALUES (
    'user3',
    'user3@bestbuds.local',
    'password789',
    'ROLE_USER',
    FALSE
);

-- Profiles
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
    1,
    'Test',
    'User',
    '1990-05-15',
    '123 Main Street',
    NULL,
    'Columbus',
    'OH',
    '43215'
);

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
    2,
    'Second',
    'User',
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL
);

COMMIT TRANSACTION;