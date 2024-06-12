package com.bosch.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CityData")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "Country")
    private String country;

    @Column(name = "City")
    private String name;

    @Column(name = "States")
    private String state;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return name;
    }

    public void setCity(String city) {
        this.name = city;
    }

    public String getStates() {
        return state;
    }

    public void setStates(String states) {
        this.state = states;
    }
}
