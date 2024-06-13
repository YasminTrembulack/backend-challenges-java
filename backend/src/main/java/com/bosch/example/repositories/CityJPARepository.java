package com.bosch.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bosch.example.model.City;
import java.util.List;

@Repository
public interface CityJPARepository 
    extends JpaRepository<City, Long>{
    List<City> findByName(String city);
}
