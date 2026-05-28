package com.example.demo.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    // Clé secrète (doit faire au moins 32 caractères pour HS256)
    private static final String SECRET = "ndjan_soko_super_secret_key_2026_keyce_ia_bachelor_2";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 jours

    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String phoneNumber, String role) {
        return Jwts.builder()
                .subject(phoneNumber)
                .claims(Map.of("role", role))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
}
