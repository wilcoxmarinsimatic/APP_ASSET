package com.example.lector_rfid.domain.ports;

import com.example.lector_rfid.domain.entities.User;

public interface UserRepository {
    User login(String email, String password,Boolean isWeb) throws Exception;
}