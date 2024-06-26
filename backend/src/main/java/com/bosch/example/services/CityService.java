package com.bosch.example.services;

import java.util.List;
import com.bosch.example.model.City;

public interface CityService {
    List<City> findByName(String search);
    List<City> getAllCities();
}
