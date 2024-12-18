package com.cimatic.lector_rfid.infrastructure.api;

import com.cimatic.lector_rfid.infrastructure.repositories.LoginRequest;
import com.cimatic.lector_rfid.infrastructure.repositories.UserResponse;
import com.cimatic.lector_rfid.infrastructure.util.CallbackApi;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

public class ApiServiceImpl implements ApiService {

    OkHttpClient client = new OkHttpClient();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    @Override
    public void login(LoginRequest request, CallbackApi callbackApi) {
        new Thread(()->{
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
                    UserResponse data = gson.fromJson(responseBody, UserResponse.class);
                    callbackApi.onSuccess(data);
                }
            } catch (Exception e) {
                callbackApi.onError(e);
            }
        }).start();
    }
}
