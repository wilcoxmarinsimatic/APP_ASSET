package com.example.lector_rfid.application.di;

import com.example.lector_rfid.domain.usecase.LoginUseCase;
import com.example.lector_rfid.infrastructure.repositories.UserRepositoryImpl;
import com.example.lector_rfid.infrastructure.api.ApiService;
import com.example.lector_rfid.infrastructure.api.ApiServiceImpl;

public class AppModule {

    public static LoginUseCase provideLoginUseCase() {
        ApiService apiService = new ApiServiceImpl();
        UserRepositoryImpl userRepository = new UserRepositoryImpl(apiService);
        return new LoginUseCase(userRepository);
    }
}
