package com.pradeepl.productapi.controllers;

import com.pradeepl.productapi.models.Product;
import com.pradeepl.productapi.models.Product.ProductRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

@RestController
@CrossOrigin("*")
 // For CORS
public class VulnerableProductController {

    @Autowired
    private DataSource dataSource; // Inject the DataSource

    @GetMapping("/products/vulnerable/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name) {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery
                ("SELECT * FROM product WHERE name = '" + name + "'")) {

                    List<Product> products = new ArrayList<>();
                    while (resultSet.next()) {
                        Product product = new Product();                        
                        product.setName(resultSet.getString("name"));
                        product.setPrice(resultSet.getDouble("price"));
                        products.add(product);
            }
            return ResponseEntity.ok(products);

        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
//#region vulnerable code
    //the vuln is not identified in this method but is identified in the one below it
    @PostMapping("/products/vulnerable") // New endpoint for demonstration
    public ResponseEntity<String> testProduct21(@RequestBody ProductRecord productRecord) {
        switch (productRecord) {
            case ProductRecord(int id, String name, double price) 
                when name.contains("<script>") -> { // Vulnerable: potential injection
                // This part is vulnerable since 'name' is not sanitized
                return ResponseEntity.ok("Processing product: " + name); 
            }
            default -> {
                return ResponseEntity.ok("Product processed.");
            }
        }
    }

    @PostMapping("/products/vulnerabletest") // New endpoint for demonstration
    public ResponseEntity<String> testProduct17(@RequestBody ProductRecord productRecord) {
        return ResponseEntity.ok("Processing product: " + productRecord.name()); 
    }
//#endregion
}