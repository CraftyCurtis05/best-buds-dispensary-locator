-- **************************************************************
-- Best Buds
-- Adds development data to the database
-- **************************************************************

BEGIN TRANSACTION;

-- Users
INSERT INTO users (
    username,
    email,
    password_hash,
    role
)
VALUES (
    'user',
    'user1@bestbuds.local',
    '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',
    'ROLE_USER'
);

INSERT INTO users (
    username,
    email,
    password_hash,
    role
)
VALUES (
    'admin',
    'admin@bestbuds.local',
    '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',
    'ROLE_ADMIN'
);

COMMIT TRANSACTION;
