package com.bestbuds.dao;

import com.bestbuds.model.User;
import com.bestbuds.exception.DaoException;
import com.bestbuds.exception.UserAlreadyExistsException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class JdbcUserDao implements UserDao {

    private static final String DEFAULT_ROLE =
            "ROLE_USER";

    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;

    public JdbcUserDao(
            JdbcTemplate jdbcTemplate,
            PasswordEncoder passwordEncoder
    ) {
        this.jdbcTemplate = jdbcTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserById(int userId) {

        String sql =
                "SELECT user_id, username, password_hash, role, age_confirmed "
                        + "FROM users "
                        + "WHERE user_id = ?";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            userId
                    );

            if (results.next()) {
                return mapRowToUser(results);
            }

            return null;

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(
                    "Unable to connect to the database",
                    e
            );
        }
    }

    @Override
    public User getUserByUsername(String username) {

        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException(
                    "Username cannot be empty"
            );
        }

        String sql =
                "SELECT user_id, username, password_hash, role, age_confirmed "
                        + "FROM users "
                        + "WHERE LOWER(username) = LOWER(?)";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            username
                    );

            if (results.next()) {
                return mapRowToUser(results);
            }

            return null;

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(
                    "Unable to connect to the database",
                    e
            );
        }
    }

    @Override
    public User createUser(
            String username,
            String password
    ) {

        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException(
                    "Username cannot be empty"
            );
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException(
                    "Password cannot be empty"
            );
        }

        String sql =
                "INSERT INTO users "
                        + "(username, password_hash, role) "
                        + "VALUES (?, ?, ?) "
                        + "RETURNING user_id";

        String normalizedUsername =
                username.trim().toLowerCase();

        if (usernameExists(normalizedUsername)) {
            throw new UserAlreadyExistsException(
                    "Username is already in use."
            );
        }

        String passwordHash =
                passwordEncoder.encode(password);

        try {
            Integer newUserId =
                    jdbcTemplate.queryForObject(
                            sql,
                            Integer.class,
                            normalizedUsername,
                            passwordHash,
                            DEFAULT_ROLE
                    );

            return getUserById(
                    Objects.requireNonNull(newUserId)
            );

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(
                    "Unable to connect to the database",
                    e
            );

        } catch (DataIntegrityViolationException e) {
            throw new UserAlreadyExistsException(
                    "Username is already in use."
            );
        }
    }

    @Override
    public void confirmAge(int userId) {

        String sql =
                "UPDATE users "
                        + "SET age_confirmed = TRUE "
                        + "WHERE user_id = ?";

        try {
            int rowsUpdated =
                    jdbcTemplate.update(
                            sql,
                            userId
                    );

            if (rowsUpdated == 0) {
                throw new DaoException(
                        "User not found",
                        new IllegalArgumentException(
                                "No user exists with ID: " + userId
                        )
                );
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(
                    "Unable to connect to the database",
                    e
            );
        }
    }

    // Check whether a username is already in use
    private boolean usernameExists(
            String username
    ) {

        String sql =
                "SELECT COUNT(*) "
                        + "FROM users "
                        + "WHERE LOWER(username) = LOWER(?)";

        try {
            Integer count =
                    jdbcTemplate.queryForObject(
                            sql,
                            Integer.class,
                            username
                    );

            return count != null
                    && count > 0;

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(
                    "Unable to connect to the database",
                    e
            );
        }
    }

    // Convert a database row into a user
    private User mapRowToUser(SqlRowSet results) {

        User user =
                new User();

        user.setId(
                results.getInt("user_id")
        );

        user.setUsername(
                results.getString("username")
        );

        user.setPassword(
                results.getString("password_hash")
        );

        user.setAuthorities(
                Objects.requireNonNull(
                        results.getString("role")
                )
        );

        user.setAgeConfirmed(
                results.getBoolean("age_confirmed")
        );

        return user;
    }
}