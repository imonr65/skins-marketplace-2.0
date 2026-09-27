package com.marketplace.account.auth.services;


import com.marketplace.account.auth.dto.LoginRequest;
import com.marketplace.account.auth.dto.TokensPair;
import com.marketplace.account.auth.dto.UserRegisterRequest;

public interface AuthenticationService  {

    void register(UserRegisterRequest request);

    TokensPair login(LoginRequest request);

    TokensPair refresh(String refreshToken);

    void logout(String refreshToken);
}
