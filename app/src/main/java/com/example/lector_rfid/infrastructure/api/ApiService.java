package com.example.lector_rfid.infrastructure.api;

import com.example.lector_rfid.infrastructure.repositories.LoginRequest;
import com.example.lector_rfid.infrastructure.repositories.UserResponse;

public interface ApiService {
    UserResponse login(LoginRequest request);
}