package com.cimatic.lector_rfid.infrastructure.repositories;

import  com.cimatic.lector_rfid.domain.entities.User;
import com.cimatic.lector_rfid.domain.ports.UserRepository;
import com.cimatic.lector_rfid.infrastructure.api.ApiService;
import com.cimatic.lector_rfid.infrastructure.util.CallbackApi;

public class UserRepositoryImpl implements UserRepository {

    private final ApiService apiService;

    public UserRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public User login(String email, String password,Boolean isWeb) throws Exception {
        LoginRequest request = new LoginRequest(email, password, false);
        UserResponse  userResponse = new UserResponse();
        apiService.login(request, new CallbackApi<UserResponse>() {
            @Override
            public void onSuccess(UserResponse payload) {
                userResponse.setId(payload.getId());
                userResponse.setName(payload.getName());
                userResponse.setEmail(payload.getEmail());
                userResponse.setToken(payload.getToken());
            }

            @Override
            public void onError(Exception e) {
                throw new IllegalArgumentException("Inicio de sesión fallido.");
            }
        });


        return new User(userResponse.getId(), userResponse.getName(), userResponse.getEmail(), userResponse.getToken());
    }

}
