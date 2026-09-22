package com.bestbuds.dao;

import com.bestbuds.model.PasswordResetToken;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JdbcPasswordResetTokenDaoTests
        extends BaseDaoTests {

    private PasswordResetTokenDao sut;

    @BeforeEach
    public void setup() {
        JdbcTemplate jdbcTemplate =
                new JdbcTemplate(
                        dataSource
                );

        sut =
                new JdbcPasswordResetTokenDao(
                        jdbcTemplate
                );
    }

    @Test
    public void createToken_creates_token() {

        LocalDateTime expiresAt =
                LocalDateTime.now()
                        .plusMinutes(
                                30
                        )
                        .truncatedTo(
                                ChronoUnit.MICROS
                        );

        PasswordResetToken token =
                sut.createToken(
                        1,
                        "test-token-hash",
                        expiresAt
                );

        assertNotNull(
                token
        );

        assertTrue(
                token.getId() > 0
        );

        assertEquals(
                1,
                token.getUserId()
        );

        assertEquals(
                "test-token-hash",
                token.getTokenHash()
        );

        assertEquals(
                expiresAt,
                token.getExpiresAt()
        );

        assertFalse(
                token.isUsed()
        );
    }

    @Test
    public void getTokenByHash_returns_token() {

        LocalDateTime expiresAt =
                LocalDateTime.now()
                        .plusMinutes(
                                30
                        );

        PasswordResetToken createdToken =
                sut.createToken(
                        1,
                        "find-token-hash",
                        expiresAt
                );

        PasswordResetToken foundToken =
                sut.getTokenByHash(
                        "find-token-hash"
                );

        assertNotNull(
                foundToken
        );

        assertEquals(
                createdToken.getId(),
                foundToken.getId()
        );

        assertEquals(
                1,
                foundToken.getUserId()
        );

        assertEquals(
                "find-token-hash",
                foundToken.getTokenHash()
        );
    }

    @Test
    public void getTokenByHash_returns_null_when_token_does_not_exist() {

        PasswordResetToken token =
                sut.getTokenByHash(
                        "missing-token-hash"
                );

        assertNull(
                token
        );
    }

    @Test
    public void markTokenAsUsed_marks_token_as_used() {

        PasswordResetToken createdToken =
                sut.createToken(
                        1,
                        "used-token-hash",
                        LocalDateTime.now()
                                .plusMinutes(
                                        30
                                )
                );

        sut.markTokenAsUsed(
                createdToken.getId()
        );

        PasswordResetToken updatedToken =
                sut.getTokenByHash(
                        "used-token-hash"
                );

        assertNotNull(
                updatedToken
        );

        assertTrue(
                updatedToken.isUsed()
        );
    }
}