package com.example.lector_rfid.infrastructure.api;

import com.example.lector_rfid.infrastructure.repositories.LoginRequest;
import com.example.lector_rfid.infrastructure.repositories.UserResponse;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

public class ApiServiceImpl implements ApiService {

    private final OkHttpClient client;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public ApiServiceImpl() {
        this.client = new OkHttpClient();
    }

    @Override
    public UserResponse login(LoginRequest request) {
        String loginUrl = ApiConfig.BASE_URL + ApiConfig.LOGIN_ENDPOINT;

        Gson gson = new Gson();
        String requestBodyJson = gson.toJson(request);

        RequestBody body = RequestBody.create(requestBodyJson, JSON);

        Request httpRequest = new Request.Builder()
                .url(loginUrl)
                .post(body)
                .build();

        try (Response response = client.newCall(httpRequest).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseBody = response.body().string();
                return gson.fromJson(responseBody, UserResponse.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
