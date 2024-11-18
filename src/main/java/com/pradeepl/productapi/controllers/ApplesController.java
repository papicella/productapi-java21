package com.pradeepl.productapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pradeepl.productapi.DatabaseService;

@RestController
public class ApplesController {

    DatabaseService databaseService;

    @GetMapping("/passord")
    public String getPassword () {
        return databaseService.getAwsRDSkey();
    }

}
