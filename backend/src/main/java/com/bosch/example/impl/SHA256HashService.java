package com.bosch.example.impl;



import java.security.MessageDigest;

import com.bosch.example.services.HashService;

import java.nio.charset.StandardCharsets;



public class SHA256HashService implements HashService {

    @Override
    public byte[] hash(String input) {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
            byte[] encodedhash = digest.digest(bytes);
            return encodedhash;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}