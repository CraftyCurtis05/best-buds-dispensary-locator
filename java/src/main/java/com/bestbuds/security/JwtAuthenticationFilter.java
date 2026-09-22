package com.bestbuds.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String BEARER_PREFIX =
            "Bearer ";

    private final TokenProvider tokenProvider;

    public JwtAuthenticationFilter(
            TokenProvider tokenProvider
    ) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String token =
                resolveToken(request);

        if (token != null
                && tokenProvider.validateToken(token)) {

            Authentication authentication =
                    tokenProvider.getAuthentication(
                            token
                    );

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authentication);
        }

        filterChain.doFilter(
                request,
                response
        );
    }

    // Extract the JWT from the Authorization header
    private String resolveToken(
            HttpServletRequest request
    ) {

        String authorizationHeader =
                request.getHeader(
                        HttpHeaders.AUTHORIZATION
                );

        if (StringUtils.hasText(authorizationHeader)
                && authorizationHeader.startsWith(
                        BEARER_PREFIX
                )) {

            return authorizationHeader.substring(
                    BEARER_PREFIX.length()
            );
        }

        return null;
    }
}