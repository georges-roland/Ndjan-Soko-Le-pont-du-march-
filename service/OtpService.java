package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OtpService {

    // Stockage temporaire en mémoire (Numéro -> Code)
    // Dans un vrai projet, on utiliserait Redis avec une expiration (TTL)
    private final Map<String, String> otpStorage = new ConcurrentHashMap<>();

    public String generateOtp(String phoneNumber) {
        String otp = String.format("%06d", new Random().nextInt(999999));
        otpStorage.put(phoneNumber, otp);
        
        // Simulation d'envoi SMS : On affiche le code dans la console
        System.out.println("-----------------------------------------");
        System.out.println("SMS SIMULÉ pour " + phoneNumber + " : " + otp);
        System.out.println("-----------------------------------------");
        
        return otp;
    }

    public boolean verifyOtp(String phoneNumber, String code) {
        String storedCode = otpStorage.get(phoneNumber);
        if (storedCode != null && storedCode.equals(code)) {
            otpStorage.remove(phoneNumber); // Code utilisé, on le supprime
            return true;
        }
        return false;
    }
}
