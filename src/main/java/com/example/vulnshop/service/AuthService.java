package com.example.vulnshop.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@Service
public class AuthService {

    private static final String API_KEY =  "ghp_1234567890abcdefghijklmnopqrstuvwxyz";

    public String login(String username, String password) {

        if ("admin".equals(username) && "admin123".equals(password)) {
            return "Login successful";
        }

        return "Invalid credentials";
    }

    public String generateResetToken() {

        Random random = new Random();

        return String.valueOf(random.nextInt(100000));
    }

    public String md5Hash(String value) {

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] bytes = md.digest(value.getBytes());

            StringBuilder sb = new StringBuilder();

            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}