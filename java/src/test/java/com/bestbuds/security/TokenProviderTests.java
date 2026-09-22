package com.bestbuds.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TokenProviderTests {

    private static final String BASE64_SECRET =
            "VGhpcyBpcyBhIHZlcnkgbG9uZyB0ZXN0IHNlY3JldCBmb3IgQmVzdCBCdWRzIEpXVCB0b2tlbiBzaWduaW5nLg==";

    private TokenProvider tokenProvider;

    @BeforeEach
    public void setup() {

        tokenProvider =
                new TokenProvider(
                        BASE64_SECRET,
                        3600,
                        7200
                );

        tokenProvider.afterPropertiesSet();
    }

    @Test
    public void createToken_creates_valid_token() {

        Authentication authentication =
                createAuthentication();

        String token =
                tokenProvider.createToken(
                        authentication,
                        false
                );

        assertTrue(
                tokenProvider.validateToken(token)
        );
    }

    @Test
    public void getAuthentication_returns_correct_username() {

        Authentication authentication =
                createAuthentication();

        String token =
                tokenProvider.createToken(
                        authentication,
                        false
                );

        Authentication result =
                tokenProvider.getAuthentication(
                        token
                );

        assertEquals(
                "user1",
                result.getName()
        );
    }

    @Test
    public void getAuthentication_returns_correct_authorities() {

        Authentication authentication =
                createAuthentication();

        String token =
                tokenProvider.createToken(
                        authentication,
                        false
                );

        Authentication result =
                tokenProvider.getAuthentication(
                        token
                );

        assertTrue(
                result.getAuthorities()
                        .contains(
                                new SimpleGrantedAuthority(
                                        "ROLE_USER"
                                )
                        )
        );
    }

    @Test
    public void validateToken_with_modified_token_returns_false() {

        Authentication authentication =
                createAuthentication();

        String token =
                tokenProvider.createToken(
                        authentication,
                        false
                );

        String modifiedToken =
                modifyToken(token);

        assertFalse(
                tokenProvider.validateToken(
                        modifiedToken
                )
        );
    }

    @Test
    public void validateToken_with_invalid_token_returns_false() {

        assertFalse(
                tokenProvider.validateToken(
                        "not-a-valid-token"
                )
        );
    }

    @Test
    public void validateToken_with_expired_token_returns_false()
            throws InterruptedException {

        TokenProvider shortLivedTokenProvider =
                new TokenProvider(
                        BASE64_SECRET,
                        1,
                        1
                );

        shortLivedTokenProvider.afterPropertiesSet();

        String token =
                shortLivedTokenProvider.createToken(
                        createAuthentication(),
                        false
                );

        Thread.sleep(1100);

        assertFalse(
                shortLivedTokenProvider.validateToken(
                        token
                )
        );
    }

    private Authentication createAuthentication() {

        return new UsernamePasswordAuthenticationToken(
                "user1",
                "password123",
                List.of(
                        new SimpleGrantedAuthority(
                                "ROLE_USER"
                        )
                )
        );
    }

        // Modify the signed payload without creating a new signature
        private String modifyToken(
                String token
        ) {

        int firstPeriod =
                token.indexOf('.');

        int payloadPosition =
                firstPeriod + 1;

        char currentCharacter =
                token.charAt(
                        payloadPosition
                );

        char replacementCharacter =
                currentCharacter == 'a'
                        ? 'b'
                        : 'a';

        return token.substring(
                0,
                payloadPosition
        )
                + replacementCharacter
                + token.substring(
                        payloadPosition + 1
                );
        }
}