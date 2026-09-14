package com.marketplace.auth.services;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryRefreshTokenStoreImpl implements RefreshTokenStore {

    private record Entry(UUID userId, Instant expiresAt) {}

    private final Map<String, Entry> store = new ConcurrentHashMap<>();

    @Override
    public void save(String jti, UUID userId, Duration expiration) {
        store.put(jti, new Entry(userId, Instant.now().plus(expiration)));
    }

    @Override
    public boolean isActive(String jti) {
        Entry e = store.get(jti);
        if (e == null) {
            return false;
        }
        if (e.expiresAt().isBefore(Instant.now())) {
            store.remove(jti);
            return false;
        }
        return true;
    }

    @Override
    public void revoke(String jti) {
        store.remove(jti);
    }

    @Override
    public void revokeAllForUser(UUID userId) {
        store.entrySet().removeIf(e -> e.getValue().userId.equals(userId));
    }
}
