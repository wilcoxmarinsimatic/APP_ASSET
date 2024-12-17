package com.example.lector_rfid.infrastructure.api;

import com.example.lector_rfid.application.adapters.ActivoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ActivoApi {
    @GET("/activos")
    Call<List<ActivoAdapter.Activo>> getActivos(
            @Query("codigoRFID") String codigoRFID,
            @Query("nombreActivo") String nombreActivo,
            @Query("page") int page,
            @Query("pageSize") int pageSize
    );
}
