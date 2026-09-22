package com.bestbuds.model;

public class UpdateUsernameResponseDto {

    private String username;
    private String email;
    private boolean reauthenticationRequired;

    public UpdateUsernameResponseDto() {
    }

    public UpdateUsernameResponseDto(
            String username,
            String email,
            boolean reauthenticationRequired
    ) {
        this.username = username;
        this.email = email;
        this.reauthenticationRequired =
                reauthenticationRequired;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(
            String username
    ) {
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

    public boolean isReauthenticationRequired() {
        return reauthenticationRequired;
    }

    public void setReauthenticationRequired(
            boolean reauthenticationRequired
    ) {
        this.reauthenticationRequired =
                reauthenticationRequired;
    }
}