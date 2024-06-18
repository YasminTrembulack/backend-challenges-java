package com.bosch.example.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.model.Product;
import com.bosch.example.repositories.ProductJPARepository;
import com.bosch.example.services.ProductService;

public class DatabaseProduct implements ProductService{
   @Autowired
    ProductJPARepository repo; 

    @Override
    public void save(Product product) {
        repo.save(product);
    }
}
