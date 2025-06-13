package com.XGroup.PrepX.Backend.Config;

import org.springframework.stereotype.Component;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class JwtKeyGenerator {
    
    public static String generateSecureKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            keyGen.init(256); // Using 256-bit key
            SecretKey secretKey = keyGen.generateKey();
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating JWT key", e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Generated JWT Key: " + generateSecureKey());
    }
} 