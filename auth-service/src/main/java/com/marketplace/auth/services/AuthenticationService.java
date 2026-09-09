package com.marketplace.auth.services;

import com.marketplace.auth.dto.JwtAuthenticationResponse;
import com.marketplace.auth.dto.LoginRequest;
import com.marketplace.auth.dto.UserRegisterRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService  {

    void register(UserRegisterRequest request);

    JwtAuthenticationResponse signIn(LoginRequest request);

}
