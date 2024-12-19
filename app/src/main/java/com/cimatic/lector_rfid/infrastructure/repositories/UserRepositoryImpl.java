package com.cimatic.lector_rfid.infrastructure.repositories;

import com.cimatic.lector_rfid.domain.entities.User;
import com.cimatic.lector_rfid.domain.ports.UserRepository;
import com.cimatic.lector_rfid.infrastructure.api.ApiService;
import com.cimatic.lector_rfid.infrastructure.util.CallbackApi;

import java.util.concurrent.CompletableFuture;

public class UserRepositoryImpl implements UserRepository {

    private final ApiService apiService;

    public UserRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public CompletableFuture<User> login(String email, String password, Boolean isWeb) {
        CompletableFuture<User> future = new CompletableFuture<>();
        LoginRequest request = new LoginRequest(email, password, isWeb);

        apiService.login(request, new CallbackApi<UserResponse>() {
            @Override
            public void onSuccess(UserResponse payload) {
                User user = new User(payload.getId(), payload.getName(), payload.getEmail(), payload.getToken());
                future.complete(user); // Completa el futuro con el usuario
            }

            @Override
            public void onError(Exception e) {
                future.completeExceptionally(new IllegalArgumentException("Inicio de sesión fallido.", e));
            }
        });

        return future;
    }
}
