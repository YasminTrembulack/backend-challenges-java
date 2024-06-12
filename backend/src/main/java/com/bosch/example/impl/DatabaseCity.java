package com.bosch.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.model.City;
import com.bosch.example.services.CitiesService;

public class DatabaseCity implements CitiesService{

    @Autowired
    CitiesService repo;

    @Override
    public List<City> findByCity(String search ){
        return repo.findByCity(search);
    };

    @Override
    public List<City> getAllCities(){
        return repo.getAllCities();
    };
}
