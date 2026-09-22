package com.bestbuds.dao;

import com.bestbuds.model.PasswordResetToken;

import java.time.LocalDateTime;

public interface PasswordResetTokenDao {

    PasswordResetToken createToken(
            int userId,
            String tokenHash,
            LocalDateTime expiresAt
    );

    PasswordResetToken getTokenByHash(
            String tokenHash
    );

    void markTokenAsUsed(
            int tokenId
    );
}