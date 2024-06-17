package com.bosch.example.impl;

import java.util.Arrays;

import com.bosch.example.services.PasswordValidatorService;

public class DefaultPasswordValidate implements PasswordValidatorService{
    @Override
    public boolean validate(String pass){
        if (pass == null) 
            return false;
        
        if (pass.length() < 8) 
            return false;

        Boolean[] conditions = new Boolean[3];    
        
        pass.chars()
            .forEach(i -> {
                if ('a' <= i && i <= 'z')
                    conditions[0] = true;
                
                if ('A' <= i && i <= 'Z')
                    conditions[1] = true;
                
                if ('0' <= i && i <= '9')
                    conditions[2] = true;
        });

        return Arrays.stream(conditions).allMatch(b -> b);
    }

    
}