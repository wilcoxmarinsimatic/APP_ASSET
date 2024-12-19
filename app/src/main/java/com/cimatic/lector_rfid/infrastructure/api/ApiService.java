package com.cimatic.lector_rfid.infrastructure.api;

import com.cimatic.lector_rfid.infrastructure.repositories.LoginRequest;
import com.cimatic.lector_rfid.infrastructure.util.CallbackApi;

public interface ApiService {
    void login(LoginRequest request, CallbackApi callbackApi);
}
