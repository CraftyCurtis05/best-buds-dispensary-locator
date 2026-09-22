package com.bestbuds.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ResetPasswordDto {

    @NotBlank(
            message = "Reset token is required."
    )
    private String token;

    @NotBlank(
            message = "New password is required."
    )
    @Size(
            min = 8,
            max = 100,
            message = "New password must be between 8 and 100 characters."
    )
    private String newPassword;

    @NotBlank(
            message = "Password confirmation is required."
    )
    private String confirmPassword;

    public String getToken() {
        return token;
    }

    public void setToken(
            String token
    ) {
        this.token = token;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(
            String newPassword
    ) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(
            String confirmPassword
    ) {
        this.confirmPassword =
                confirmPassword;
    }
}