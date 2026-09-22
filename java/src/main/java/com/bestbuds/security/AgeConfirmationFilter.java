package com.bestbuds.security;

import com.bestbuds.model.User;
import com.bestbuds.service.AgeConfirmationService;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.exception.AgeConfirmationRequiredException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class AgeConfirmationFilter
        extends OncePerRequestFilter {

    private final AgeConfirmationService ageConfirmationService;
    private final AuthenticationService authenticationService;

    public AgeConfirmationFilter(
            AgeConfirmationService ageConfirmationService,
            AuthenticationService authenticationService
    ) {
        this.ageConfirmationService = ageConfirmationService;
        this.authenticationService = authenticationService;
    }

    // Skip age confirmation for authentication and age confirmation requests
    @Override
    protected boolean shouldNotFilter(
            HttpServletRequest request
    ) {

        String requestPath =
                request.getServletPath();

        return requestPath.startsWith("/api/auth/")
                || requestPath.equals("/api/age/confirm");
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        if (authentication != null
                && authentication.isAuthenticated()) {

            User user =
                    authenticationService.getUser(
                            authentication.getName()
                    );

            try {
                ageConfirmationService.requireAgeConfirmation(
                        user
                );

            } catch (AgeConfirmationRequiredException e) {
                response.sendError(
                        HttpServletResponse.SC_FORBIDDEN,
                        e.getMessage()
                );

                return;
            }
        }

        filterChain.doFilter(
                request,
                response
        );
    }
}