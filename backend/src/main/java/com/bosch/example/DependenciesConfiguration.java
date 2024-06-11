package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.DefaultImaginaryExp;
import com.bosch.example.impl.DefaultPlaindrome;
import com.bosch.example.services.ImaginaryExpService;
import com.bosch.example.services.Plaindrome;

@Configuration
public class DependenciesConfiguration {

    @Bean
    @Scope("singleton")
    public Plaindrome plaindrome(){
        return new DefaultPlaindrome();      
    }

    @Bean
    @Scope("singleton")
    public ImaginaryExpService ieService(){
        return new DefaultImaginaryExp();      
    }
}
