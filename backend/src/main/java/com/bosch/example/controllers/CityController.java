package com.bosch.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.model.City;
import com.bosch.example.services.CitiesService;

@RestController
public class CityController {
    @Autowired
    CitiesService repo;


    @GetMapping("/cities")
    public List<City> getMethodName() {
        System.out.println(repo.getAllCities());
        return repo.getAllCities();
    }

    @GetMapping("/cities/{search}")
    public List<City> getMethod(@PathVariable String city) {
        System.out.println(repo.findByCity(city));
        return repo.findByCity(city);
    }

    
}