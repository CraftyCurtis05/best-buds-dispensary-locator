package com.bestbuds.security;

import com.bestbuds.exception.AgeConfirmationRequiredException;
import com.bestbuds.model.User;
import com.bestbuds.service.AgeConfirmationService;
import com.bestbuds.service.AuthenticationService;

import java.util.Collections;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AgeConfirmationFilterTests {

    private AgeConfirmationService ageConfirmationService;
    private AuthenticationService authenticationService;
    private AgeConfirmationFilter sut;

    @BeforeEach
    public void setUp() {

        ageConfirmationService =
                mock(AgeConfirmationService.class);

        authenticationService =
                mock(AuthenticationService.class);

        sut =
                new AgeConfirmationFilter(
                        ageConfirmationService,
                        authenticationService
                );
    }

    @AfterEach
    public void tearDown() {

        SecurityContextHolder.clearContext();
    }

    @Test
    public void authentication_request_skips_age_confirmation()
            throws Exception {

        MockHttpServletRequest request =
                new MockHttpServletRequest(
                        "POST",
                        "/api/auth/login"
                );

        MockHttpServletResponse response =
                new MockHttpServletResponse();

        FilterChain filterChain =
                mock(FilterChain.class);

        sut.doFilter(
                request,
                response,
                filterChain
        );

        verify(
                authenticationService,
                never()
        ).getUser(
                "user1"
        );

        verify(filterChain)
                .doFilter(
                        request,
                        response
                );
    }

    @Test
    public void age_confirmation_request_skips_age_confirmation()
            throws Exception {

        MockHttpServletRequest request =
                new MockHttpServletRequest(
                        "POST",
                        "/api/age/confirm"
                );

        MockHttpServletResponse response =
                new MockHttpServletResponse();

        FilterChain filterChain =
                mock(FilterChain.class);

        sut.doFilter(
                request,
                response,
                filterChain
        );

        verify(
                ageConfirmationService,
                never()
        ).requireAgeConfirmation(
                org.mockito.ArgumentMatchers.any()
        );

        verify(filterChain)
                .doFilter(
                        request,
                        response
                );
    }

    @Test
    public void protected_request_requires_age_confirmation()
            throws Exception {

        User user =
                new User();

        UsernamePasswordAuthenticationToken authentication =
                UsernamePasswordAuthenticationToken.authenticated(
                        "user1",
                        null,
                        Collections.emptyList()
                );

        SecurityContextHolder
                .getContext()
                .setAuthentication(
                        authentication
                );

        when(authenticationService.getUser("user1"))
                .thenReturn(
                        user
                );

        MockHttpServletRequest request =
                new MockHttpServletRequest(
                        "GET",
                        "/api/dispensaries/search"
                );

        MockHttpServletResponse response =
                new MockHttpServletResponse();

        FilterChain filterChain =
                mock(FilterChain.class);

        sut.doFilter(
                request,
                response,
                filterChain
        );

        verify(authenticationService)
                .getUser(
                        "user1"
                );

        verify(ageConfirmationService)
                .requireAgeConfirmation(
                        user
                );

        verify(filterChain)
                .doFilter(
                        request,
                        response
                );
    }

    @Test
    public void protected_request_stops_when_age_is_not_confirmed()
            throws Exception {

        User user =
                new User();

        UsernamePasswordAuthenticationToken authentication =
                UsernamePasswordAuthenticationToken.authenticated(
                        "user1",
                        null,
                        java.util.Collections.emptyList()
                );

        SecurityContextHolder
                .getContext()
                .setAuthentication(
                        authentication
                );

        when(authenticationService.getUser("user1"))
                .thenReturn(
                        user
                );

        doThrow(
                new AgeConfirmationRequiredException(
                        "Age confirmation is required."
                )
        )
                .when(ageConfirmationService)
                .requireAgeConfirmation(
                        user
                );

        MockHttpServletRequest request =
                new MockHttpServletRequest(
                        "GET",
                        "/api/dispensaries/search"
                );

        MockHttpServletResponse response =
                new MockHttpServletResponse();

        FilterChain filterChain =
                mock(FilterChain.class);

        sut.doFilter(
                request,
                response,
                filterChain
        );

        assertEquals(
                HttpServletResponse.SC_FORBIDDEN,
                response.getStatus()
        );

        verify(
                filterChain,
                never()
        ).doFilter(
                request,
                response
        );
    }
}