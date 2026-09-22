package com.bestbuds.service;

import org.springframework.stereotype.Service;

@Service
public class ConsoleEmailService
        implements EmailService {

    @Override
    public void sendPasswordResetEmail(
            String email,
            String resetToken
    ) {

        // Temporary email implementation for development
        System.out.println(
                "Password reset requested for: "
                        + email
        );
    }
}