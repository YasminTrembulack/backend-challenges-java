package com.bosch.example.services;

import java.util.List;
import com.bosch.example.model.City;

public interface CitiesService {
    List<City> findByCity(String search );
    List<City> getAllCities();
}
