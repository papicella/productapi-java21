package com.pradeepl.productapi;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    private String userName = "admin";
    private String key = "ehehenekie3646!";

    private String awsRDSkey = "${key}";
    private String password = "shwhehe67whd!";

    public String getPassword () {
        return password;
    }

    public String getAwsRDSkey() {
        return awsRDSkey;
    }


}