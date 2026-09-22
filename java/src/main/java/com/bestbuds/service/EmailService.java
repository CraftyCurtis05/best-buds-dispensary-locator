package com.bestbuds.service;

public interface EmailService {

    void sendPasswordResetEmail(
            String email,
            String resetToken
    );
}