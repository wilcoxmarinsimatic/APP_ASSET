package com.cimatic.lector_rfid.domain.ports;

import com.cimatic.lector_rfid.domain.entities.Auditoria;

import java.util.List;

public interface AuditoriaRepository {
    List<Auditoria> getAllAuditorias();
}
