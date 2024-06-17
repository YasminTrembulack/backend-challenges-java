package com.bosch.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.bosch.example.dto.ViaCEPJson;
import com.bosch.example.services.CityValidatorService;

public class ViaCEPCityValidator  implements CityValidatorService{
    @Autowired
    private RestTemplate rest;

    @Override
    public boolean validate(String cep, String city){
        String url = "http://viacep.com.br/ws/" + cep + "/json";
        ViaCEPJson obj = rest.getForObject(url, ViaCEPJson.class);
        return obj.localidade() == city;
    }
}
