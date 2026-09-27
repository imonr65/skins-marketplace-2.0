package com.marketplace.account.auth.services;

import java.time.Duration;
import java.util.UUID;


public interface RefreshTokenStore {
    //Todo: сделать реализацию хранения токена в бд - Redis

    void save(String jti, UUID userId, Duration expiration);

    boolean isActive(String jti);

    void revoke(String jti);

    void revokeAllForUser(UUID userId);
}
