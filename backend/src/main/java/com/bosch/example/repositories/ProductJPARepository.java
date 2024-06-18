package com.bosch.example.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bosch.example.model.Product;

public interface ProductJPARepository extends JpaRepository<Product, Long> {}
