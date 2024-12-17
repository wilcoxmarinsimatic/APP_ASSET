package com.example.lector_rfid.infrastructure.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.lector_rfid.application.adapters.ActivoAdapter.Activo;

import java.util.List;

@Dao
public interface ActivoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Activo> activos);

    @Query("SELECT * FROM activos WHERE codigoRFID LIKE :codigoRFID")
    List<Activo> getActivosByCodigo(String codigoRFID);
}
