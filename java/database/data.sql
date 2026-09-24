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

-- Best Buds Collectibles
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