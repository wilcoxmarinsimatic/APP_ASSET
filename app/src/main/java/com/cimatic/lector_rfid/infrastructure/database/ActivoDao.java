package com.cimatic.lector_rfid.infrastructure.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.cimatic.lector_rfid.application.mappers.Activo;

import java.util.List;

@Dao
public interface ActivoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Activo> activos);

    @Query("SELECT * FROM activos WHERE codigoRFID LIKE :codigoRFID")
    List<Activo> getActivosByCodigo(String codigoRFID);
}
