package com.bestbuds.controller;

import com.bestbuds.dao.UserDao;
import com.bestbuds.exception.DaoException;
import com.bestbuds.model.LoginDto;
import com.bestbuds.model.LoginResponseDto;
import com.bestbuds.model.RegisterUserDto;
import com.bestbuds.model.User;
import com.bestbuds.security.jwt.JWTFilter;
import com.bestbuds.security.jwt.TokenProvider;

import jakarta.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserDao userDao;

    public AuthenticationController(
            TokenProvider tokenProvider,
            AuthenticationManagerBuilder authenticationManagerBuilder,
            UserDao userDao
    ) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDao = userDao;
    }

    // Authenticate the user and return an authorization token
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @Valid @RequestBody LoginDto loginDto
    ) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                );

        Authentication authentication =
                authenticationManagerBuilder
                        .getObject()
                        .authenticate(authenticationToken);

        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication, false);

        User user;

        try {
            user = userDao.getUserByUsername(loginDto.getUsername());
        } catch (DaoException e) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Username or password is incorrect."
            );
        }

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add(
                JWTFilter.AUTHORIZATION_HEADER,
                "Bearer " + jwt
        );

        LoginResponseDto response =
                new LoginResponseDto(jwt, user);

        return new ResponseEntity<>(
                response,
                httpHeaders,
                HttpStatus.OK
        );
    }

    // Register a new user
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(
            @Valid @RequestBody RegisterUserDto newUser
    ) {

        try {

            User user = userDao.createUser(newUser);

            if (user == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "User registration failed."
                );
            }

        } catch (DaoException e) {

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "User registration failed."
            );
        }
    }

}
