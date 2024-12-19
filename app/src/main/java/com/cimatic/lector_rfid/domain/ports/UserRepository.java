package com.cimatic.lector_rfid.domain.ports;

import com.cimatic.lector_rfid.domain.entities.User;
import java.util.concurrent.CompletableFuture;

public interface UserRepository {
    CompletableFuture<User> login(String email, String password, Boolean isWeb);
}
