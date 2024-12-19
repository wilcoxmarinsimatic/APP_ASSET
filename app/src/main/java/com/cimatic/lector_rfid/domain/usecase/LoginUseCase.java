package com.cimatic.lector_rfid.domain.usecase;

import com.cimatic.lector_rfid.domain.entities.User;
import com.cimatic.lector_rfid.domain.ports.UserRepository;

import java.util.concurrent.CompletableFuture;

public class LoginUseCase {

    private final UserRepository userRepository;

    public LoginUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CompletableFuture<User> execute(String email, String password) {
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            CompletableFuture<User> future = new CompletableFuture<>();
            future.completeExceptionally(new IllegalArgumentException("Email y contraseña no pueden estar vacíos."));
            return future;
        }

        return userRepository.login(email, password, false);
    }
}
