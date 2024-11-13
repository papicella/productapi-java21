package com.pradeepl.productapi.config;

import com.pradeepl.productapi.models.Product;
import com.pradeepl.productapi.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseSeeder {
    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    new Product("Product1", 10.0),
                    new Product("Product2", 15.0)
            ));
        };
    }
}
