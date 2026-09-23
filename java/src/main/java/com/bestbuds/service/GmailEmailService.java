package com.bestbuds.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class GmailEmailService
        implements EmailService {

    private final JavaMailSender mailSender;
    private final String emailFrom;
    private final String frontendUrl;

    public GmailEmailService(
            JavaMailSender mailSender,
            @Value("${app.email.from}") String emailFrom,
            @Value("${app.frontend-url}") String frontendUrl
    ) {
        this.mailSender = mailSender;
        this.emailFrom = emailFrom;
        this.frontendUrl = frontendUrl;
    }

    @Override
    public void sendPasswordResetEmail(
            String email,
            String resetToken
    ) {

        String resetUrl =
                frontendUrl
                        + "/reset-password?token="
                        + resetToken;

        try {
            MimeMessage message =
                    mailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(
                            message,
                            false,
                            "UTF-8"
                    );

            helper.setFrom(
                    emailFrom
            );

            helper.setTo(
                    email
            );

            helper.setSubject(
                    "Reset your Best Buds password"
            );

            helper.setText(
                    createPasswordResetEmail(
                            resetUrl
                    ),
                    true
            );

            mailSender.send(
                    message
            );

        } catch (MessagingException e) {
            throw new IllegalStateException(
                    "Unable to create password reset email",
                    e
            );
        }
    }

    // Build the password reset email
    private String createPasswordResetEmail(
            String resetUrl
    ) {

        return "<p>You requested a password reset for your Best Buds account.</p>"
                + "<p><a href=\""
                + resetUrl
                + "\">Reset your password</a></p>"
                + "<p>This link will expire in 30 minutes.</p>"
                + "<p>If you did not request this reset, you can ignore this email.</p>";
    }
}