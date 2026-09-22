package com.bestbuds.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateUsernameDto {

    @NotBlank(
            message = "Username is required."
    )
    @Size(
            min = 3,
            max = 50,
            message = "Username must be between 3 and 50 characters."
    )
    private String username;

    @NotBlank(
            message = "Current password is required."
    )
    private String currentPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(
            String username
    ) {
        this.username = username;
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