package com.bosch.example.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bosch.example.services.EmailValidatorService;

public class DefaultEmailValidator implements EmailValidatorService {

    @Override
    public boolean validate(String email) {
        if (email == null)
            return false;

        email = email.trim();
        
        if (email.length() < 4)
            return false;

        Pattern pattern = Pattern.compile("[A-Za-z0-9_\\.]@[A-Za-z0-9_\\.]"); 
        Matcher matcher = pattern.matcher(email);
        if (!matcher.find())
            return false;

        return (matcher.end() - matcher.start()) != email.length();
    }

}