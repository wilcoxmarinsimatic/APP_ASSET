package com.cimatic.lector_rfid.infrastructure.api;

import com.cimatic.lector_rfid.application.adapters.ActivoAdapter;
import com.cimatic.lector_rfid.application.mappers.Activo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ActivoApi {
    @GET("/activos")
    Call<List<Activo>> getActivos(
            @Query("codigoRFID") String codigoRFID,
            @Query("nombreActivo") String nombreActivo,
            @Query("page") int page,
            @Query("pageSize") int pageSize
    );
}
