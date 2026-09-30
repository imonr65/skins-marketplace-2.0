package com.marketplace.account.auth.controllers;

import com.marketplace.account.auth.dto.TokenResponse;
import com.marketplace.account.auth.dto.TokensPair;
import com.marketplace.account.auth.services.AuthenticationService;
import com.marketplace.account.auth.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CookieValue;
import java.time.Duration;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody @Valid UserRegisterRequest userRegisterRequestDto) {
        authenticationService.register(userRegisterRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid LoginRequest request) {
        TokensPair tokens = authenticationService.login(request);

        return setRefreshTokenInCookieAndReturnAccessToken(tokens);
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refresh(
            @CookieValue(name = "refresh_token", required = false) String refreshToken
    ) {
        if (refreshToken == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        TokensPair tokensPair = authenticationService.refresh(refreshToken);

        return setRefreshTokenInCookieAndReturnAccessToken(tokensPair);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(
            @CookieValue(name = "refresh_token", required = false) String refreshToken
    ) {
        authenticationService.logout(refreshToken);
        return ResponseEntity.noContent()
                .header(HttpHeaders.SET_COOKIE, clearRefreshCookie().toString())
                .build();
    }

    private ResponseEntity<TokenResponse> setRefreshTokenInCookieAndReturnAccessToken(TokensPair tokens) {
        ResponseCookie cookie = ResponseCookie.from("refresh_token", tokens.getRefreshToken())
                .httpOnly(true)
                .secure(false) //todo: узнать особенности настройки куки
                .sameSite("Strict")
                .maxAge(Duration.ofDays(30)) //Todo: убрать магическое число
                .path("/auth")
                .build();
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new TokenResponse(tokens.getAccessToken()));
    }

    private ResponseCookie clearRefreshCookie() {
        return ResponseCookie
                .from("refresh_token", "")
                .path("/auth")
                .httpOnly(true)
                .secure(false)
                .sameSite("Strict")
                .maxAge(0)
                .build();
    }
}
