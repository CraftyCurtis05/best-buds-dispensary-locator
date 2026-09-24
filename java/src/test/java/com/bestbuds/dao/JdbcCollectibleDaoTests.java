package com.bestbuds.dao;

import com.bestbuds.model.Collectible;
import com.bestbuds.model.UserCollectible;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcCollectibleDaoTests
        extends BaseDaoTests {

    private JdbcTemplate jdbcTemplate;
    private JdbcCollectibleDao jdbcCollectibleDao;

    @BeforeEach
    public void setup() {

        jdbcTemplate =
                new JdbcTemplate(
                        dataSource
                );

        jdbcCollectibleDao =
                new JdbcCollectibleDao(
                        jdbcTemplate
                );

        createTestCollectibles();
    }

    @Test
    public void getCollectibleByCode_returns_collectible() {

        Collectible collectible =
                jdbcCollectibleDao.getCollectibleByCode(
                        "BIRTHDAY_BUD"
                );

        assertNotNull(
                collectible
        );

        assertTrue(
                collectible.getId() > 0
        );

        assertEquals(
                "BIRTHDAY_BUD",
                collectible.getCode()
        );

        assertEquals(
                "Birthday Bud",
                collectible.getName()
        );

        assertEquals(
                "A little something from your Best Buds. Happy birthday!",
                collectible.getDescription()
        );

        assertEquals(
                "SPECIAL",
                collectible.getRarity()
        );

        assertEquals(
                "BIRTHDAY",
                collectible.getCategory()
        );

        assertFalse(
                collectible.isSecret()
        );
    }

    @Test
    public void getCollectibleByCode_returns_null_when_collectible_does_not_exist() {

        Collectible collectible =
                jdbcCollectibleDao.getCollectibleByCode(
                        "MISSING_COLLECTIBLE"
                );

        assertNull(
                collectible
        );
    }

    @Test
    public void getUserCollectibles_returns_user_collectibles() {

        jdbcCollectibleDao.unlockCollectible(
                1,
                "BIRTHDAY_BUD"
        );

        jdbcCollectibleDao.unlockCollectible(
                1,
                "TRAIL_BLAZER"
        );

        List<UserCollectible> userCollectibles =
                jdbcCollectibleDao.getUserCollectibles(
                        1
                );

        assertEquals(
                2,
                userCollectibles.size()
        );

        assertTrue(
                userCollectibles.stream()
                        .anyMatch(userCollectible ->
                                "BIRTHDAY_BUD".equals(
                                        userCollectible
                                                .getCollectible()
                                                .getCode()
                                )
                        )
        );

        assertTrue(
                userCollectibles.stream()
                        .anyMatch(userCollectible ->
                                "TRAIL_BLAZER".equals(
                                        userCollectible
                                                .getCollectible()
                                                .getCode()
                                )
                        )
        );
    }

    @Test
    public void getUserCollectibles_returns_empty_list_when_none_exist() {

        List<UserCollectible> userCollectibles =
                jdbcCollectibleDao.getUserCollectibles(
                        3
                );

        assertNotNull(
                userCollectibles
        );

        assertTrue(
                userCollectibles.isEmpty()
        );
    }

    @Test
    public void getUserCollectible_returns_user_collectible() {

        UserCollectible unlockedCollectible =
                jdbcCollectibleDao.unlockCollectible(
                        1,
                        "GOLDEN_BUD"
                );

        UserCollectible foundCollectible =
                jdbcCollectibleDao.getUserCollectible(
                        1,
                        "GOLDEN_BUD"
                );

        assertNotNull(
                foundCollectible
        );

        assertEquals(
                unlockedCollectible,
                foundCollectible
        );

        assertEquals(
                1,
                foundCollectible.getUserId()
        );

        assertEquals(
                "GOLDEN_BUD",
                foundCollectible
                        .getCollectible()
                        .getCode()
        );

        assertTrue(
                foundCollectible
                        .getCollectible()
                        .isSecret()
        );

        assertNotNull(
                foundCollectible.getUnlockedAt()
        );
    }

    @Test
    public void getUserCollectible_returns_null_when_not_found() {

        UserCollectible userCollectible =
                jdbcCollectibleDao.getUserCollectible(
                        1,
                        "BIRTHDAY_BUD"
                );

        assertNull(
                userCollectible
        );
    }

    @Test
    public void getUserCollectible_does_not_return_another_users_collectible() {

        jdbcCollectibleDao.unlockCollectible(
                1,
                "BUD_KEEPER"
        );

        UserCollectible anotherUsersCollectible =
                jdbcCollectibleDao.getUserCollectible(
                        2,
                        "BUD_KEEPER"
                );

        assertNull(
                anotherUsersCollectible
        );
    }

    @Test
    public void unlockCollectible_unlocks_collectible() {

        UserCollectible userCollectible =
                jdbcCollectibleDao.unlockCollectible(
                        1,
                        "BIRTHDAY_BUD"
                );

        assertNotNull(
                userCollectible
        );

        assertTrue(
                userCollectible.getId() > 0
        );

        assertEquals(
                1,
                userCollectible.getUserId()
        );

        assertEquals(
                "BIRTHDAY_BUD",
                userCollectible
                        .getCollectible()
                        .getCode()
        );

        assertNotNull(
                userCollectible.getUnlockedAt()
        );
    }

    @Test
    public void unlockCollectible_does_not_create_duplicate_collectible() {

        UserCollectible firstUnlock =
                jdbcCollectibleDao.unlockCollectible(
                        1,
                        "TRAIL_BLAZER"
                );

        UserCollectible secondUnlock =
                jdbcCollectibleDao.unlockCollectible(
                        1,
                        "TRAIL_BLAZER"
                );

        List<UserCollectible> userCollectibles =
                jdbcCollectibleDao.getUserCollectibles(
                        1
                );

        assertNotNull(
                firstUnlock
        );

        assertNotNull(
                secondUnlock
        );

        assertEquals(
                firstUnlock.getId(),
                secondUnlock.getId()
        );

        assertEquals(
                1,
                userCollectibles.size()
        );
    }

    @Test
    public void unlockCollectible_returns_null_when_collectible_does_not_exist() {

        UserCollectible userCollectible =
                jdbcCollectibleDao.unlockCollectible(
                        1,
                        "MISSING_COLLECTIBLE"
                );

        assertNull(
                userCollectible
        );

        List<UserCollectible> userCollectibles =
                jdbcCollectibleDao.getUserCollectibles(
                        1
                );

        assertTrue(
                userCollectibles.isEmpty()
        );
    }

    // Create collectible data used by DAO tests
    private void createTestCollectibles() {

        String sql =
                "INSERT INTO collectibles "
                        + "(code, name, description, rarity, category, is_secret) "
                        + "VALUES "
                        + "('BIRTHDAY_BUD', 'Birthday Bud', "
                        + "'A little something from your Best Buds. Happy birthday!', "
                        + "'SPECIAL', 'BIRTHDAY', FALSE), "
                        + "('TRAIL_BLAZER', 'Trail Blazer', "
                        + "'There is always another trail to blaze.', "
                        + "'COMMON', 'EXPLORATION', FALSE), "
                        + "('BUD_KEEPER', 'Bud Keeper', "
                        + "'You know a good bud when you find one.', "
                        + "'COMMON', 'COLLECTION', FALSE), "
                        + "('GOLDEN_BUD', 'Golden Bud', "
                        + "'Some things are worth searching for.', "
                        + "'RARE', 'SECRET', TRUE)";

        jdbcTemplate.update(
                sql
        );
    }
}