package com.cimatic.lector_rfid.infrastructure.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivoService {
    private static final String BASE_URL = "https://tu-backend.com/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ActivoApi getActivoApi() {
        return getRetrofitInstance().create(ActivoApi.class);
    }
}
