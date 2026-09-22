package com.bestbuds.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TokenProvider implements InitializingBean {

    private static final Logger LOG =
            LoggerFactory.getLogger(TokenProvider.class);

    private static final String AUTHORITIES_KEY =
            "auth";

    private final String base64Secret;
    private final long tokenValidityInMilliseconds;
    private final long tokenValidityInMillisecondsForRememberMe;

    private SecretKey key;

    public TokenProvider(
            @Value("${jwt.base64-secret}") String base64Secret,
            @Value("${jwt.token-validity-in-seconds}") long tokenValidityInSeconds,
            @Value("${jwt.token-validity-in-seconds-for-remember-me}") long tokenValidityInSecondsForRememberMe
    ) {
        this.base64Secret = base64Secret;

        this.tokenValidityInMilliseconds =
                tokenValidityInSeconds * 1000;

        this.tokenValidityInMillisecondsForRememberMe =
                tokenValidityInSecondsForRememberMe * 1000;
    }

    // Create the signing key from the configured secret
    @Override
    public void afterPropertiesSet() {

        byte[] keyBytes =
                Decoders.BASE64.decode(
                        base64Secret
                );

        key =
                Keys.hmacShaKeyFor(
                        keyBytes
                );
    }

    // Create a signed token for the authenticated user
    public String createToken(
            Authentication authentication,
            boolean rememberMe
    ) {

        String authorities =
                getAuthorities(
                        authentication
                );

        Instant now =
                Instant.now();

        long validityInMilliseconds =
                rememberMe
                        ? tokenValidityInMillisecondsForRememberMe
                        : tokenValidityInMilliseconds;

        Instant expiration =
                now.plusMillis(
                        validityInMilliseconds
                );

        return Jwts.builder()
                .subject(authentication.getName())
                .claim(
                        AUTHORITIES_KEY,
                        authorities
                )
                .issuedAt(
                        Date.from(now)
                )
                .expiration(
                        Date.from(expiration)
                )
                .signWith(
                        key,
                        Jwts.SIG.HS512
                )
                .compact();
    }

    // Build Spring Security authentication from a valid token
    public Authentication getAuthentication(
            String token
    ) {

        Claims claims =
                getClaims(token);

        List<GrantedAuthority> authorities =
                getAuthorities(claims);

        User principal =
                new User(
                        claims.getSubject(),
                        "",
                        authorities
                );

        return new UsernamePasswordAuthenticationToken(
                principal,
                token,
                authorities
        );
    }

    // Check whether a token is valid and properly signed
    public boolean validateToken(
            String token
    ) {

        try {

            getClaims(token);

            return true;

        } catch (SecurityException
                 | MalformedJwtException exception) {

            LOG.debug(
                    "Invalid JWT signature.",
                    exception
            );

        } catch (ExpiredJwtException exception) {

            LOG.debug(
                    "Expired JWT token.",
                    exception
            );

        } catch (UnsupportedJwtException exception) {

            LOG.debug(
                    "Unsupported JWT token.",
                    exception
            );

        } catch (IllegalArgumentException exception) {

            LOG.debug(
                    "Invalid JWT token.",
                    exception
            );
        }

        return false;
    }

    // Convert Spring Security authorities into a token claim
    private String getAuthorities(
            Authentication authentication
    ) {

        List<String> authorities =
                new ArrayList<>();

        for (GrantedAuthority authority :
                authentication.getAuthorities()) {

            authorities.add(
                    authority.getAuthority()
            );
        }

        return String.join(
                ",",
                authorities
        );
    }

    // Convert the token authority claim into Spring Security authorities
    private List<GrantedAuthority> getAuthorities(
            Claims claims
    ) {

        List<GrantedAuthority> authorities =
                new ArrayList<>();

        String authorityClaim =
                claims.get(
                        AUTHORITIES_KEY,
                        String.class
                );

        if (authorityClaim == null
                || authorityClaim.isBlank()) {

            return authorities;
        }

        String[] authorityNames =
                authorityClaim.split(",");

        for (String authorityName :
                authorityNames) {

            authorities.add(
                    new SimpleGrantedAuthority(
                            authorityName
                    )
            );
        }

        return authorities;
    }

    // Read and verify the claims stored in a token
    private Claims getClaims(
            String token
    ) {

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}