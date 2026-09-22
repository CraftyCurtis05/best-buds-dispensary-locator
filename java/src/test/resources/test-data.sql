BEGIN TRANSACTION;

-- Users
INSERT INTO users (
    username,
    email,
    password_hash,
    role
)
VALUES (
    'user1',
    'user1@bestbuds.local',
    'password123',
    'ROLE_USER'
);

INSERT INTO users (
    username,
    email,
    password_hash,
    role
)
VALUES (
    'user2',
    'user2@bestbuds.local',
    'password456',
    'ROLE_USER'
);

INSERT INTO users (
    username,
    email,
    password_hash,
    role
)
VALUES (
    'user3',
    'user3@bestbuds.local',
    'password789',
    'ROLE_USER'
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