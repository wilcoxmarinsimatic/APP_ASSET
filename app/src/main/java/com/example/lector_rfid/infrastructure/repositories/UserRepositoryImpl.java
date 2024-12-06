package com.example.lector_rfid.infrastructure.repositories;

import  com.example.lector_rfid.domain.entities.User;
import com.example.lector_rfid.domain.ports.UserRepository;
import com.example.lector_rfid.infrastructure.api.ApiService;

public class UserRepositoryImpl implements UserRepository {

    private final ApiService apiService;

    public UserRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public User login(String email, String password,Boolean isWeb) throws Exception {
        LoginRequest request = new LoginRequest(email, password, false);
        UserResponse response = apiService.login(request);

        if (response == null || response.getToken() == null) {
            throw new Exception("Inicio de sesión fallido.");
        }

        return new User(response.getId(), response.getName(), response.getEmail(), response.getToken());
    }

}
