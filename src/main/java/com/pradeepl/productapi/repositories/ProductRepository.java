package com.pradeepl.productapi.repositories;

import com.pradeepl.productapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // No additional methods needed, JpaRepository provides CRUD operations.   
}
