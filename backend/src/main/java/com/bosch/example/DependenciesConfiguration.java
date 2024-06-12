package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.DatabaseCity;
import com.bosch.example.impl.DefaultCollatz;
import com.bosch.example.impl.DefaultImaginaryExp;
import com.bosch.example.impl.DefaultPalindrome;
import com.bosch.example.services.CitiesService;
import com.bosch.example.services.CollatzService;
import com.bosch.example.services.ImaginaryExpService;
import com.bosch.example.services.PalindromeService;

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
    public CitiesService citiesService(){
        return new DatabaseCity();      
    }
}
