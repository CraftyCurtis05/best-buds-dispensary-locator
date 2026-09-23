package com.bestbuds.service;

import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GmailEmailServiceTests {

    private JavaMailSender mailSender;
    private GmailEmailService sut;

    @BeforeEach
    public void setup() {

        mailSender =
                mock(JavaMailSender.class);

        sut =
                new GmailEmailService(
                        mailSender,
                        "Best Buds <bestbudslocator@gmail.com>",
                        "http://localhost:5173"
                );
    }

    @Test
    public void sendPasswordResetEmail_sends_reset_email()
            throws Exception {

        MimeMessage message =
                new MimeMessage(
                        Session.getInstance(
                                new Properties()
                        )
                );

        when(mailSender.createMimeMessage())
                .thenReturn(
                        message
                );

        sut.sendPasswordResetEmail(
                "user1@bestbuds.local",
                "test-reset-token"
        );

        assertEquals(
                "Reset your Best Buds password",
                message.getSubject()
        );

        assertEquals(
                "user1@bestbuds.local",
                message.getAllRecipients()[0].toString()
        );

        String emailContent =
                message.getContent()
                        .toString();

        assertTrue(
                emailContent.contains(
                        "http://localhost:5173/reset-password?token=test-reset-token"
                )
        );

        verify(mailSender).send(
                message
        );
    }
}