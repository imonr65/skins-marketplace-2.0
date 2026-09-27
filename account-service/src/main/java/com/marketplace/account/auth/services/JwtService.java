package com.marketplace.account.auth.services;

import com.marketplace.account.auth.models.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

@Service
public class JwtService {

    private final Duration accessExpiration;

    private final Duration refreshExpiration;

    private final SecretKey signingKey;

    private final JwtParser parser;

    public JwtService(
            @Value("${token.signing.key}") String jwtSigningKey,
            @Value("${token.access.ttl}") Duration accessTtl,
            @Value("${token.refresh.ttl}") Duration refreshTtl
    ) {
        this.signingKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(jwtSigningKey));
        this.accessExpiration = accessTtl;
        this.refreshExpiration = refreshTtl;
        this.parser = Jwts.parser().verifyWith(signingKey).build();
    }

    public String generateAccessToken(User user) {
        return generateToken(user, accessExpiration, "access_token");
    }

    public String generateRefreshToken(User user) {
        return generateToken(user, refreshExpiration, "refresh_token");
    }


    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private String generateToken(User user, Duration tokenExpiration, String tokenType) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("role", user.getRole().name());

        return Jwts.builder()
                .claims(claims)
                .claim("type", tokenType)
                .id(UUID.randomUUID().toString())
                .subject(user.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + tokenExpiration.toMillis()))
                .signWith(signingKey)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails, String expectedType) {
        try {
            Claims claims = extractAllClaims(token);
            return claims.getSubject().equals(userDetails.getUsername())
                    && !isTokenExpired(token)
                    && expectedType.equals(claims.get("type", String.class));
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public boolean isAccessToken(Claims claims) {
        return "access_token".equals(claims.get("type", String.class));
    }

    public boolean isRefresh(Claims claims) {
        return "refresh_token".equals(claims.get("type", String.class));
    }

    public UUID extractUserId(Claims claims) {
        return UUID.fromString(claims.get("id", String.class));
    }

    public UserRole extractRole(Claims claims) {
        return UserRole.valueOf(claims.get("role", String.class));
    }

    public Claims parse(String token) {
        return parser.parseSignedClaims(token).getPayload();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(signingKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }



}
