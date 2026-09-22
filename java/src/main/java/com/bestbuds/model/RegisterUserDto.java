package com.bestbuds.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

public class RegisterUserDto {

    @NotBlank(message = "Username is required.")
    @Size(
            min = 3,
            max = 50,
            message = "Username must be between 3 and 50 characters."
    )
    private String username;

    @NotBlank(
        message = "Email is required."
    )
    @Email(
            message = "Email must be valid."
    )
    @Size(
            max = 254,
            message = "Email must be 254 characters or fewer."
    )
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(
            min = 8,
            max = 100,
            message = "Password must be between 8 and 100 characters."
    )
    private String password;

    @NotBlank(message = "Password confirmation is required.")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(
            String email
    ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(
            String confirmPassword
    ) {
        this.confirmPassword = confirmPassword;
    }
}