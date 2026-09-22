package com.bestbuds.controller;

import com.bestbuds.model.LoginDto;
import com.bestbuds.model.LoginResponseDto;
import com.bestbuds.model.RegisterUserDto;
import com.bestbuds.model.User;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.security.TokenProvider;

import jakarta.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final TokenProvider tokenProvider;

    public AuthenticationController(
            AuthenticationService authenticationService,
            TokenProvider tokenProvider
    ) {
        this.authenticationService = authenticationService;
        this.tokenProvider = tokenProvider;
    }

    // Authenticate the user and return an authorization token
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @Valid @RequestBody LoginDto loginDto
    ) {

        Authentication authentication =
                authenticationService.authenticate(
                        loginDto
                );

        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);

        String jwt =
                tokenProvider.createToken(
                        authentication,
                        false
                );

        User user =
                authenticationService.getUser(
                        loginDto.getUsername()
                );

        HttpHeaders httpHeaders =
                new HttpHeaders();

        httpHeaders.add(
                HttpHeaders.AUTHORIZATION,
                "Bearer " + jwt
        );

        LoginResponseDto response =
                new LoginResponseDto(
                        jwt,
                        user
                );

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
			@Valid @RequestBody RegisterUserDto registration
	) {

		authenticationService.register(
				registration
		);
	}
}