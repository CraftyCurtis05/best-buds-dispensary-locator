package com.bestbuds.exception;

import jakarta.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GlobalExceptionHandlerTests {

    @Test
    public void handleDaoException_returns_internal_server_error() {

        GlobalExceptionHandler handler =
                new GlobalExceptionHandler();

        HttpServletRequest request =
                mock(HttpServletRequest.class);

        when(
                request.getRequestURI()
        ).thenReturn(
                "/api/test"
        );

        DaoException exception =
                new DaoException(
                        "Unable to connect to the database",
                        new RuntimeException()
                );

        ResponseEntity<ApiError> response =
                handler.handleDaoException(
                        exception,
                        request
                );

        assertEquals(
                HttpStatus.INTERNAL_SERVER_ERROR,
                response.getStatusCode()
        );

        assertEquals(
                500,
                response.getBody().getStatus()
        );

        assertEquals(
                "Internal Server Error",
                response.getBody().getError()
        );

        assertEquals(
                "An unexpected database error occurred.",
                response.getBody().getMessage()
        );

        assertEquals(
                "/api/test",
                response.getBody().getPath()
        );
    }

    @Test
    public void handleUserAlreadyExistsException_returns_conflict() {

        GlobalExceptionHandler handler =
                new GlobalExceptionHandler();

        HttpServletRequest request =
                mock(HttpServletRequest.class);

        when(
                request.getRequestURI()
        ).thenReturn(
                "/api/auth/register"
        );

        UserAlreadyExistsException exception =
                new UserAlreadyExistsException(
                        "Username is already in use."
                );

        ResponseEntity<ApiError> response =
                handler.handleUserAlreadyExistsException(
                        exception,
                        request
                );

        assertEquals(
                HttpStatus.CONFLICT,
                response.getStatusCode()
        );

        assertEquals(
                409,
                response.getBody().getStatus()
        );

        assertEquals(
                "Conflict",
                response.getBody().getError()
        );

        assertEquals(
                "Username is already in use.",
                response.getBody().getMessage()
        );

        assertEquals(
                "/api/auth/register",
                response.getBody().getPath()
        );
    }

    @Test
    public void handleAgeConfirmationRequiredException_returns_forbidden() {

        GlobalExceptionHandler handler =
                new GlobalExceptionHandler();

        HttpServletRequest request =
                mock(HttpServletRequest.class);

        when(request.getRequestURI())
                .thenReturn(
                        "/api/dispensaries/search"
                );

        AgeConfirmationRequiredException exception =
                new AgeConfirmationRequiredException(
                        "Age confirmation is required."
                );

        ResponseEntity<ApiError> response =
                handler.handleAgeConfirmationRequiredException(
                        exception,
                        request
                );

        assertEquals(
                HttpStatus.FORBIDDEN,
                response.getStatusCode()
        );

        assertNotNull(
                response.getBody()
        );

        assertEquals(
                HttpStatus.FORBIDDEN.value(),
                response.getBody().getStatus()
        );

        assertEquals(
                "Forbidden",
                response.getBody().getError()
        );

        assertEquals(
                "Age confirmation is required.",
                response.getBody().getMessage()
        );

        assertEquals(
                "/api/dispensaries/search",
                response.getBody().getPath()
        );
    }
}