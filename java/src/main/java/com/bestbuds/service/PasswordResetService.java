package com.bestbuds.service;

import com.bestbuds.dao.PasswordResetTokenDao;
import com.bestbuds.dao.UserDao;
import com.bestbuds.model.User;
import com.bestbuds.model.PasswordResetToken;
import com.bestbuds.model.ResetPasswordDto;
import com.bestbuds.exception.InvalidPasswordResetTokenException;
import com.bestbuds.exception.RegistrationException;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HexFormat;

@Service
public class PasswordResetService {

    private static final int TOKEN_BYTES =
            32;

    private static final int TOKEN_VALID_MINUTES =
            30;

    private final UserDao userDao;
    private final PasswordResetTokenDao passwordResetTokenDao;
    private final SecureRandom secureRandom;
    private final EmailService emailService;

    public PasswordResetService(
            UserDao userDao,
            PasswordResetTokenDao passwordResetTokenDao,
            EmailService emailService
    ) {
        this.userDao = userDao;
        this.passwordResetTokenDao =
                passwordResetTokenDao;
        this.emailService =
                emailService;

        this.secureRandom =
                new SecureRandom();
    }

    public String createResetToken(
            String email
    ) {

        User user =
                userDao.getUserByEmail(
                        email
                );

        if (user == null) {
            return null;
        }

        String token =
                generateToken();

        String tokenHash =
                hashToken(
                        token
                );

        LocalDateTime expiresAt =
                LocalDateTime.now()
                        .plusMinutes(
                                TOKEN_VALID_MINUTES
                        );

        passwordResetTokenDao.createToken(
                user.getId(),
                tokenHash,
                expiresAt
        );

        emailService.sendPasswordResetEmail(
                user.getEmail(),
                token
        );

        return token;
    }

    public void resetPassword(
            ResetPasswordDto resetPassword
    ) {

        if (!resetPassword
                .getNewPassword()
                .equals(
                        resetPassword.getConfirmPassword()
                )) {
            throw new RegistrationException(
                    "Passwords do not match."
            );
        }

        String tokenHash =
                hashToken(
                        resetPassword.getToken()
                );

        PasswordResetToken storedToken =
                passwordResetTokenDao.getTokenByHash(
                        tokenHash
                );

        if (storedToken == null
                || storedToken.isUsed()
                || storedToken
                        .getExpiresAt()
                        .isBefore(
                                LocalDateTime.now()
                        )) {
            throw new InvalidPasswordResetTokenException(
                    "Password reset token is invalid or expired."
            );
        }

        userDao.updatePassword(
                storedToken.getUserId(),
                resetPassword.getNewPassword()
        );

        passwordResetTokenDao.markTokenAsUsed(
                storedToken.getId()
        );
    }

    // Generate a secure random token for the reset link
    private String generateToken() {

        byte[] tokenBytes =
                new byte[TOKEN_BYTES];

        secureRandom.nextBytes(
                tokenBytes
        );

        return Base64
                .getUrlEncoder()
                .withoutPadding()
                .encodeToString(
                        tokenBytes
                );
    }

    // Hash the token before storing it in the database
    private String hashToken(
            String token
    ) {

        try {
            MessageDigest digest =
                    MessageDigest.getInstance(
                            "SHA-256"
                    );

            byte[] tokenHash =
                    digest.digest(
                            token.getBytes(
                                    StandardCharsets.UTF_8
                            )
                    );

            return HexFormat
                    .of()
                    .formatHex(
                            tokenHash
                    );

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(
                    "SHA-256 is not available",
                    e
            );
        }
    }
}