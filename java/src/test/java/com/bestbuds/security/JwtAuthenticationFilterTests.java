package com.bestbuds.security;

import jakarta.servlet.FilterChain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class JwtAuthenticationFilterTests {

    @Mock
    private TokenProvider tokenProvider;

    @Mock
    private Authentication authentication;

    @Mock
    private FilterChain filterChain;

    private JwtAuthenticationFilter sut;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks(this);

        SecurityContextHolder.clearContext();

        sut = new JwtAuthenticationFilter(
                tokenProvider
        );
    }

    @AfterEach
    public void cleanup() {
        SecurityContextHolder.clearContext();
    }

    @Test
    public void filter_without_authorization_header_continues_filter_chain()
            throws Exception {

        MockHttpServletRequest request =
                new MockHttpServletRequest();

        MockHttpServletResponse response =
                new MockHttpServletResponse();

        sut.doFilter(
                request,
                response,
                filterChain
        );

        verify(
                tokenProvider,
                never()
        ).validateToken(
                org.mockito.ArgumentMatchers.anyString()
        );

        verify(filterChain).doFilter(
                request,
                response
        );

        assertNull(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
        );
    }

    @Test
    public void filter_with_valid_token_sets_authentication()
            throws Exception {

        MockHttpServletRequest request =
                new MockHttpServletRequest();

        MockHttpServletResponse response =
                new MockHttpServletResponse();

        request.addHeader(
                "Authorization",
                "Bearer valid-token"
        );

        when(
                tokenProvider.validateToken(
                        "valid-token"
                )
        ).thenReturn(true);

        when(
                tokenProvider.getAuthentication(
                        "valid-token"
                )
        ).thenReturn(authentication);

        sut.doFilter(
                request,
                response,
                filterChain
        );

        assertSame(
                authentication,
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
        );

        verify(tokenProvider).validateToken(
                "valid-token"
        );

        verify(tokenProvider).getAuthentication(
                "valid-token"
        );

        verify(filterChain).doFilter(
                request,
                response
        );
    }

    @Test
    public void filter_with_invalid_token_does_not_set_authentication()
            throws Exception {

        MockHttpServletRequest request =
                new MockHttpServletRequest();

        MockHttpServletResponse response =
                new MockHttpServletResponse();

        request.addHeader(
                "Authorization",
                "Bearer invalid-token"
        );

        when(
                tokenProvider.validateToken(
                        "invalid-token"
                )
        ).thenReturn(false);

        sut.doFilter(
                request,
                response,
                filterChain
        );

        assertNull(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
        );

        verify(tokenProvider).validateToken(
                "invalid-token"
        );

        verify(
                tokenProvider,
                never()
        ).getAuthentication(
                "invalid-token"
        );

        verify(filterChain).doFilter(
                request,
                response
        );
    }

    @Test
    public void filter_with_non_bearer_header_ignores_token()
            throws Exception {

        MockHttpServletRequest request =
                new MockHttpServletRequest();

        MockHttpServletResponse response =
                new MockHttpServletResponse();

        request.addHeader(
                "Authorization",
                "Basic credentials"
        );

        sut.doFilter(
                request,
                response,
                filterChain
        );

        verify(
                tokenProvider,
                never()
        ).validateToken(
                org.mockito.ArgumentMatchers.anyString()
        );

        verify(
                tokenProvider,
                never()
        ).getAuthentication(
                org.mockito.ArgumentMatchers.anyString()
        );

        verify(filterChain).doFilter(
                request,
                response
        );

        assertNull(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
        );
    }
}