package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

@Service
public class HashingService {

    /**
     * Calcule le hash SHA-256 d'une chaîne de caractères.
     * Utilisé pour sécuriser le registre financier (Module 5).
     */
    public String hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erreur lors du calcul du hash SHA-256", e);
        }
    }
}
