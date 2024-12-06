package com.example.lector_rfid.infrastructure.repositories;

public class LoginRequest {
    private final String email;
    private final String password;
    private final Boolean isWeb;

    public LoginRequest(String email, String password,Boolean isWeb ) {
        this.email = email;
        this.password = password;
        this.isWeb = isWeb;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public Boolean getisWeb() {
        return isWeb;
    }
}