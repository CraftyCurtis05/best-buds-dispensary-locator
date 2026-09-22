package com.bestbuds.dao;

import com.bestbuds.exception.DaoException;
import com.bestbuds.model.PasswordResetToken;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class JdbcPasswordResetTokenDao
        implements PasswordResetTokenDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPasswordResetTokenDao(
            JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PasswordResetToken createToken(
            int userId,
            String tokenHash,
            LocalDateTime expiresAt
    ) {

        String sql =
                "INSERT INTO password_reset_tokens "
                        + "(user_id, token_hash, expires_at) "
                        + "VALUES (?, ?, ?) "
                        + "RETURNING token_id";

        try {
            Integer newTokenId =
                    jdbcTemplate.queryForObject(
                            sql,
                            Integer.class,
                            userId,
                            tokenHash,
                            expiresAt
                    );

            return getTokenById(
                    Objects.requireNonNull(
                            newTokenId
                    )
            );

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(
                    "Unable to connect to the database",
                    e
            );
        }
    }

    @Override
    public PasswordResetToken getTokenByHash(
            String tokenHash
    ) {

        String sql =
                "SELECT token_id, user_id, token_hash, expires_at, used "
                        + "FROM password_reset_tokens "
                        + "WHERE token_hash = ?";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            tokenHash
                    );

            if (results.next()) {
                return mapRowToToken(
                        results
                );
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
    public void markTokenAsUsed(
            int tokenId
    ) {

        String sql =
                "UPDATE password_reset_tokens "
                        + "SET used = TRUE "
                        + "WHERE token_id = ?";

        try {
            jdbcTemplate.update(
                    sql,
                    tokenId
            );

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(
                    "Unable to connect to the database",
                    e
            );
        }
    }

    // Find a token by its database ID
    private PasswordResetToken getTokenById(
            int tokenId
    ) {

        String sql =
                "SELECT token_id, user_id, token_hash, expires_at, used "
                        + "FROM password_reset_tokens "
                        + "WHERE token_id = ?";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            tokenId
                    );

            if (results.next()) {
                return mapRowToToken(
                        results
                );
            }

            return null;

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(
                    "Unable to connect to the database",
                    e
            );
        }
    }

    // Convert a database row into a password reset token
    private PasswordResetToken mapRowToToken(
            SqlRowSet results
    ) {

        PasswordResetToken token =
                new PasswordResetToken();

        token.setId(
                results.getInt(
                        "token_id"
                )
        );

        token.setUserId(
                results.getInt(
                        "user_id"
                )
        );

        token.setTokenHash(
                results.getString(
                        "token_hash"
                )
        );

        token.setExpiresAt(
                Objects.requireNonNull(
                        results.getTimestamp(
                                "expires_at"
                        )
                ).toLocalDateTime()
        );

        token.setUsed(
                results.getBoolean(
                        "used"
                )
        );

        return token;
    }
}