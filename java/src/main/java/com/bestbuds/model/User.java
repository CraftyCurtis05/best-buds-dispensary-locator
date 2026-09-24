package com.bestbuds.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

    private int id;
    private String username;
    private String email;

    @JsonIgnore
    private String password;

    private Set<Authority> authorities =
            new HashSet<>();

    private boolean ageConfirmed;

    public User() {
    }

    public User(
            int id,
            String username,
            String password,
            String authorities
    ) {
        this.id = id;
        this.username = username;
        this.password = password;

        if (authorities != null) {
            setAuthorities(
                    authorities
            );
        }
    }

    public int getId() {
        return id;
    }

    public void setId(
            int id
    ) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(
            String password
    ) {
        this.password = password;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(
            Set<Authority> authorities
    ) {
        this.authorities = authorities;
    }

    public boolean isAgeConfirmed() {
        return ageConfirmed;
    }

    public void setAgeConfirmed(
            boolean ageConfirmed
    ) {
        this.ageConfirmed = ageConfirmed;
    }

    // Convert stored roles into user authorities
    public void setAuthorities(
            String authorities
    ) {

        this.authorities.clear();

        String[] roles =
                authorities.split(",");

        for (String role : roles) {

            String authority =
                    role.startsWith("ROLE_")
                            ? role
                            : "ROLE_" + role;

            this.authorities.add(
                    new Authority(
                            authority
                    )
            );
        }
    }

    @Override
    public boolean equals(
            Object object
    ) {

        if (this == object) {
            return true;
        }

        if (object == null
                || getClass() != object.getClass()) {
            return false;
        }

        User user =
                (User) object;

        return id == user.id
                && Objects.equals(
                        username,
                        user.username
                )
                && Objects.equals(
                        password,
                        user.password
                )
                && Objects.equals(
                        authorities,
                        user.authorities
                );
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                id,
                username,
                password,
                authorities
        );
    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}