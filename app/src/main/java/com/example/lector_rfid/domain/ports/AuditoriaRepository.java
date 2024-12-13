package com.example.lector_rfid.domain.ports;

import com.example.lector_rfid.domain.entities.Auditoria;

import java.util.List;

public interface AuditoriaRepository {
    List<Auditoria> getAllAuditorias();
}
