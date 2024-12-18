package com.cimatic.lector_rfid.domain.ports;

import com.cimatic.lector_rfid.domain.entities.User;

public interface UserRepository {
    User login(String email, String password,Boolean isWeb) throws Exception;
}