package com.bestbuds.dao;

import com.bestbuds.exception.DaoException;
import com.bestbuds.model.Collectible;
import com.bestbuds.model.UserCollectible;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCollectibleDao implements CollectibleDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectibleDao(
            JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Find a collectible by its code
    @Override
    public Collectible getCollectibleByCode(
            String code
    ) {

        Collectible collectible = null;

        String sql =
                "SELECT collectible_id, code, name, description, rarity, category, is_secret "
                        + "FROM collectibles "
                        + "WHERE code = ?";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            code
                    );

            if (results.next()) {
                collectible =
                        mapRowToCollectible(
                                results
                        );
            }

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to retrieve Collectible",
                    e
            );
        }

        return collectible;
    }

    // Find all collectibles unlocked by a user
    @Override
    public List<UserCollectible> getUserCollectibles(
            int userId
    ) {

        List<UserCollectible> userCollectibles =
                new ArrayList<>();

        String sql =
                "SELECT uc.user_collectible_id, uc.user_id, uc.unlocked_at, "
                        + "c.collectible_id, c.code, c.name, c.description, "
                        + "c.rarity, c.category, c.is_secret "
                        + "FROM user_collectibles uc "
                        + "JOIN collectibles c ON uc.collectible_id = c.collectible_id "
                        + "WHERE uc.user_id = ? "
                        + "ORDER BY uc.unlocked_at DESC";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            userId
                    );

            while (results.next()) {
                userCollectibles.add(
                        mapRowToUserCollectible(
                                results
                        )
                );
            }

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to retrieve user Collectibles",
                    e
            );
        }

        return userCollectibles;
    }

    // Find a specific collectible unlocked by a user
    @Override
    public UserCollectible getUserCollectible(
            int userId,
            String code
    ) {

        UserCollectible userCollectible = null;

        String sql =
                "SELECT uc.user_collectible_id, uc.user_id, uc.unlocked_at, "
                        + "c.collectible_id, c.code, c.name, c.description, "
                        + "c.rarity, c.category, c.is_secret "
                        + "FROM user_collectibles uc "
                        + "JOIN collectibles c ON uc.collectible_id = c.collectible_id "
                        + "WHERE uc.user_id = ? "
                        + "AND c.code = ?";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            userId,
                            code
                    );

            if (results.next()) {
                userCollectible =
                        mapRowToUserCollectible(
                                results
                        );
            }

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to retrieve user Collectible",
                    e
            );
        }

        return userCollectible;
    }

    // Unlock a collectible for a user
    @Override
    public UserCollectible unlockCollectible(
            int userId,
            String code
    ) {

        Collectible collectible =
                getCollectibleByCode(
                        code
                );

        if (collectible == null) {
            return null;
        }

        String sql =
                "INSERT INTO user_collectibles "
                        + "(user_id, collectible_id) "
                        + "VALUES (?, ?) "
                        + "ON CONFLICT (user_id, collectible_id) DO NOTHING";

        try {
            jdbcTemplate.update(
                    sql,
                    userId,
                    collectible.getId()
            );

            return getUserCollectible(
                    userId,
                    code
            );

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to unlock Collectible",
                    e
            );
        }
    }

    // Convert a database row into a Collectible
    private Collectible mapRowToCollectible(
            SqlRowSet rowSet
    ) {

        Collectible collectible =
                new Collectible();

        collectible.setId(
                rowSet.getInt(
                        "collectible_id"
                )
        );

        collectible.setCode(
                rowSet.getString(
                        "code"
                )
        );

        collectible.setName(
                rowSet.getString(
                        "name"
                )
        );

        collectible.setDescription(
                rowSet.getString(
                        "description"
                )
        );

        collectible.setRarity(
                rowSet.getString(
                        "rarity"
                )
        );

        collectible.setCategory(
                rowSet.getString(
                        "category"
                )
        );

        collectible.setSecret(
                rowSet.getBoolean(
                        "is_secret"
                )
        );

        return collectible;
    }

    // Convert a joined database row into a UserCollectible
    private UserCollectible mapRowToUserCollectible(
            SqlRowSet rowSet
    ) {

        UserCollectible userCollectible =
                new UserCollectible();

        userCollectible.setId(
                rowSet.getInt(
                        "user_collectible_id"
                )
        );

        userCollectible.setUserId(
                rowSet.getInt(
                        "user_id"
                )
        );

        userCollectible.setCollectible(
                mapRowToCollectible(
                        rowSet
                )
        );

        if (rowSet.getTimestamp("unlocked_at") != null) {
            userCollectible.setUnlockedAt(
                    rowSet.getTimestamp(
                            "unlocked_at"
                    ).toLocalDateTime()
            );
        }

        return userCollectible;
    }
}