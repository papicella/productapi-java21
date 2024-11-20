package com.pradeepl.productapi.controllers;

import com.pradeepl.productapi.models.Product;
import com.pradeepl.productapi.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.pradeepl.productapi.DatabaseService;

import java.util.List;
import java.util.Optional;

@RestController
public class ApplesRestController {

    DatabaseService databaseService;
    ProductRepository productRepository;

    @GetMapping("/passord")
    public String getPassword () {
        return databaseService.getAwsRDSkey();
    }

    @GetMapping("/findbyid/{id}")
    public Optional<Product> getProduct (@PathVariable int id) {
        Optional<Product> product = productRepository.findById(id);

        return product;
    }


}
