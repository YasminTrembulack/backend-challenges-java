package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.DatabaseCity;
import com.bosch.example.impl.DatabaseUser;
import com.bosch.example.impl.DefaultCollatz;
import com.bosch.example.impl.DefaultCuritibaRegister;
import com.bosch.example.impl.DefaultImaginaryExp;
import com.bosch.example.impl.DefaultPalindrome;
import com.bosch.example.services.CEPValidatorService;
import com.bosch.example.services.CityService;
import com.bosch.example.services.CollatzService;
import com.bosch.example.services.ImaginaryExpService;
import com.bosch.example.services.PalindromeService;
import com.bosch.example.services.UserService;

@Configuration
public class DependenciesConfiguration {

    @Bean
    @Scope("singleton")
    public PalindromeService plaindromeService(){
        return new DefaultPalindrome();      
    }

    @Bean
    @Scope("singleton")
    public ImaginaryExpService imaginaryExpService(){
        return new DefaultImaginaryExp();      
    }

    @Bean
    @Scope("singleton")
    public CollatzService collatzService(){
        return new DefaultCollatz();      
    }

    @Bean
    @Scope("singleton")
    public CEPValidatorService CEPValidatorService(){
        return new DefaultCuritibaRegister();      
    }


    @Bean
    @Scope("singleton")
    public CityService citiesService(){
        return new DatabaseCity();      
    }

    @Bean
    @Scope("singleton")
    public UserService userService(){
        return new DatabaseUser();      
    }
}
