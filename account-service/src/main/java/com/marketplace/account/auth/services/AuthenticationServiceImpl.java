package com.marketplace.account.auth.services;

import com.marketplace.account.auth.dto.LoginRequest;
import com.marketplace.account.auth.dto.TokensPair;
import com.marketplace.account.auth.dto.UserRegisterRequest;
import com.marketplace.account.auth.exceptions.EmailAlreadyExistsException;
import com.marketplace.account.auth.exceptions.InvalidTokenException;
import com.marketplace.account.auth.models.User;
import com.marketplace.account.auth.models.UserRole;
import com.marketplace.account.auth.repository.UserRepository;
import com.marketplace.account.auth.security.CustomUserDetailsImpl;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final RefreshTokenStore refreshTokenStore;

    @Value("${token.refresh.expiration}")
    private Duration refreshExpiration;

    @Override
    public void register(UserRegisterRequest request) {
        Optional<User> userOptional = userRepository.findUserByEmail(request.email());
        if (userOptional.isPresent()) {
            throw new EmailAlreadyExistsException("User already exists");
        }

        User user = User.builder()
                .id(UUID.randomUUID())
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(UserRole.USER)
                .build();

        userRepository.save(user);
    }

    @Override
    public TokensPair login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.email(),
                request.password()
        ));

        CustomUserDetailsImpl userDetails = (CustomUserDetailsImpl) authentication.getPrincipal();

        User user = userDetails.getUser();
        return issueTokens(user);
    }

    @Override
    public TokensPair refresh(String refreshToken) {
        Claims claims = jwtService.parse(refreshToken);
        if (!jwtService.isRefresh(claims)) {
            throw new InvalidTokenException("Not a refresh token");
        }

        String jti = claims.getId();
        if (!refreshTokenStore.isActive(jti)) {
            throw new InvalidTokenException("Refresh token revoked or unknown");
        }

        refreshTokenStore.revoke(jti);

        User user = User.builder()
                .id(jwtService.extractUserId(claims))
                .name(claims.getSubject())
                .role(jwtService.extractRole(claims))
                .build();
        return issueTokens(user);
    }

    @Override
    public void logout(String refreshToken) {
        if (refreshToken == null) {
            return;
        }

        try {
            Claims claims = jwtService.parse(refreshToken);
            refreshTokenStore.revoke(claims.getId());
        } catch (JwtException e) {

        }
    }

    private TokensPair issueTokens(User user) {
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        Claims refreshClaims = jwtService.parse(refreshToken);
        refreshTokenStore.save(refreshClaims.getId(), user.getId(), refreshExpiration);

        return new TokensPair(accessToken, refreshToken);
    }

}
