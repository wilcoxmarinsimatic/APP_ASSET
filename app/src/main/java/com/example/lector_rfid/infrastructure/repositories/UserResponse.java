package com.example.lector_rfid.infrastructure.repositories;

public class UserResponse {
    private String id;
    private String name;
    private String email;
    private String token;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }
}
