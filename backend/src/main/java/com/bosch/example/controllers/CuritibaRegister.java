package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bosch.example.services.CEPValidatorService;

@RestController
public class CuritibaRegister {
    @Autowired
    CEPValidatorService serv;
    
    @GetMapping("curitiba")
    public Boolean validate(String cep, String cpf){
      
        return serv.validateCEP(cep);
       
    } 
    
}
