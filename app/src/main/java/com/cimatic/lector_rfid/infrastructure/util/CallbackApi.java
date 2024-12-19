package com.cimatic.lector_rfid.infrastructure.util;

public interface CallbackApi<T> {
    void onSuccess(T payload);
    void onError(Exception e);
}
