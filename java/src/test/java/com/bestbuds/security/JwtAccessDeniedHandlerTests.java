package com.bestbuds.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.access.AccessDeniedException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JwtAccessDeniedHandlerTests {

    @Test
    public void handle_returns_forbidden_response()
            throws Exception {

        JwtAccessDeniedHandler accessDeniedHandler =
                new JwtAccessDeniedHandler();

        HttpServletRequest request =
                mock(HttpServletRequest.class);

        HttpServletResponse response =
                mock(HttpServletResponse.class);

        AccessDeniedException accessDeniedException =
                new AccessDeniedException(
                        "Internal security message"
                );

        accessDeniedHandler.handle(
                request,
                response,
                accessDeniedException
        );

        verify(response).sendError(
                HttpServletResponse.SC_FORBIDDEN,
                "Access is denied."
        );
    }
}