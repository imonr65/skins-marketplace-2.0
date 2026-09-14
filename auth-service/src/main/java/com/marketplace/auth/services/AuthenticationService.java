package com.marketplace.auth.services;

import com.marketplace.auth.dto.TokenResponse;
import com.marketplace.auth.dto.TokensPair;
import com.marketplace.auth.dto.LoginRequest;
import com.marketplace.auth.dto.UserRegisterRequest;

public interface AuthenticationService  {

    void register(UserRegisterRequest request);

    TokensPair login(LoginRequest request);

    TokensPair refresh(String refreshToken);

    void logout(String refreshToken);
}
