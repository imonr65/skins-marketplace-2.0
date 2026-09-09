package com.marketplace.auth.controllers;

import com.marketplace.auth.dto.UserRegisterRequest;
import com.marketplace.auth.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/register")
public class RegisterController {

    private final AuthenticationService authenticationService;

    public RegisterController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody UserRegisterRequest userRegisterRequestDto) {
        authenticationService.register(userRegisterRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

}
