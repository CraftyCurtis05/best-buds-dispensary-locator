package com.bestbuds.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateEmailDto {

    @NotBlank(
            message = "Email is required."
    )
    @Email(
            message = "Email must be valid."
    )
    @Size(
            max = 254,
            message = "Email cannot be longer than 254 characters."
    )
    private String email;

    @NotBlank(
            message = "Current password is required."
    )
    private String currentPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(
            String email
    ) {
        this.email = email;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(
            String currentPassword
    ) {
        this.currentPassword = currentPassword;
    }
}