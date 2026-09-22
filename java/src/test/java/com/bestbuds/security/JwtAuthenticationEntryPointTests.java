package com.bestbuds.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.AuthenticationException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JwtAuthenticationEntryPointTests {

    @Test
    public void commence_returns_unauthorized_response()
            throws Exception {

        JwtAuthenticationEntryPoint entryPoint =
                new JwtAuthenticationEntryPoint();

        HttpServletRequest request =
                mock(HttpServletRequest.class);

        HttpServletResponse response =
                mock(HttpServletResponse.class);

        AuthenticationException authenticationException =
                mock(AuthenticationException.class);

        entryPoint.commence(
                request,
                response,
                authenticationException
        );

        verify(response).sendError(
                HttpServletResponse.SC_UNAUTHORIZED,
                "Authentication is required."
        );
    }
}