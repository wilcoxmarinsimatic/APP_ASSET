package com.cimatic.lector_rfid.application.di;

import com.cimatic.lector_rfid.domain.usecase.LoginUseCase;
import com.cimatic.lector_rfid.infrastructure.repositories.UserRepositoryImpl;
import com.cimatic.lector_rfid.infrastructure.api.ApiService;
import com.cimatic.lector_rfid.infrastructure.api.ApiServiceImpl;

public class AppModule {

    public static LoginUseCase provideLoginUseCase() {
        ApiService apiService = new ApiServiceImpl();
        UserRepositoryImpl userRepository = new UserRepositoryImpl(apiService);
        return new LoginUseCase(userRepository);
    }
}
