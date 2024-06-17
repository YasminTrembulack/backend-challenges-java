package com.bosch.example;

import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.InetSocketAddress;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.bosch.example.impl.DatabaseCity;
import com.bosch.example.impl.DatabaseUser;
import com.bosch.example.impl.DefaultCPFValidator;
import com.bosch.example.impl.DefaultCollatz;
import com.bosch.example.impl.DefaultEmailValidator;
import com.bosch.example.impl.DefaultImaginaryExp;
import com.bosch.example.impl.DefaultJWTService;
import com.bosch.example.impl.DefaultPalindrome;
import com.bosch.example.impl.DefaultPasswordValidate;
import com.bosch.example.impl.RS256SignatureService;
import com.bosch.example.impl.RSAKeyService;
import com.bosch.example.impl.SHA256HashService;
import com.bosch.example.impl.SHAPasswordEncoder;  
import com.bosch.example.impl.ViaCEPCityValidator;
import com.bosch.example.services.CPFValidatorService;
import com.bosch.example.services.CityService;
import com.bosch.example.services.CityValidatorService;
import com.bosch.example.services.CollatzService;
import com.bosch.example.services.EmailValidatorService;
import com.bosch.example.services.HashService;
import com.bosch.example.services.ImaginaryExpService;
import com.bosch.example.services.KeyService;
import com.bosch.example.services.PalindromeService;
import com.bosch.example.services.PasswordValidatorService;
import com.bosch.example.services.SignatureService;
import com.bosch.example.services.UserService;

@Configuration
public class DependenciesConfiguration {

    @Bean
    @Scope("singleton")
    public <T> JWTService<T> jwtService() {
        return new DefaultJWTService<>();
    }

    @Bean
    @Scope("singleton")
    public SignatureService signatureService() {
        return new RS256SignatureService();
    }
    
    @Bean
    @Scope("singleton")
    public KeyService keyService() {
        return new RSAKeyService();
    }

    @Bean
    @Scope("singleton")
    public HashService hashService() {
        return new SHA256HashService();
    }

    @Bean
    @Scope("prototype")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
        // return new SHAPasswordEncoder();
    }




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
    public static RestTemplate restTemplate() {

        final String proxyUrl = "http://rb-proxy-ca1.bosch.com";

        final int port = 8080;
        
        Proxy proxy = new Proxy(Type.HTTP,
            new InetSocketAddress(proxyUrl, port)
        );
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setProxy(proxy);

        RestTemplate rest = new RestTemplate(factory);
        
        return rest;
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

    @Bean
    @Scope("singleton")
    public static CityValidatorService cityValidator() {
        return new ViaCEPCityValidator();
    }

    @Bean
    @Scope("singleton")
    public static CPFValidatorService cpfValidator() {
        return new DefaultCPFValidator();
    }

    @Bean
    @Scope("singleton")
    public EmailValidatorService emailValidatorServicemailValidator() {
        return new DefaultEmailValidator();
    }

    @Bean
    @Scope("singleton")
    public PasswordValidatorService passwordService() {
        return new DefaultPasswordValidate();
    }
}
