package com.cimatic.lector_rfid.domain.usecase;

import com.cimatic.lector_rfid.domain.entities.User;
import com.cimatic.lector_rfid.domain.ports.UserRepository;

public class LoginUseCase {

    private final UserRepository userRepository;

    public LoginUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String email, String password) throws Exception {
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Email y contraseña no pueden estar vacíos.");
        }

        return userRepository.login(email, password,false);
    }
}
