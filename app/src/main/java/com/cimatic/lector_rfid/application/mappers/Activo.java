package com.cimatic.lector_rfid.application.mappers;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "activos", primaryKeys = "id")
public class Activo {
    private Long id;
    private String codigoRFID;
    private String tipoActivo;
    private String descripcion;
    private String responsable;
    private String categoria;
    private String ubicacion;
    private String estado;


    public  Activo(Long id, String codigoRFID, String tipoActivo, String descripcion, String responsable, String categoria, String ubicacion, String estado) {
        this.id = id;
        this.codigoRFID = codigoRFID;
        this.tipoActivo = tipoActivo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getCodigoRFID() {
        return codigoRFID;
    }

    public String getTipoActivo() {
        return tipoActivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getEstado() {
        return estado;
    }
}
