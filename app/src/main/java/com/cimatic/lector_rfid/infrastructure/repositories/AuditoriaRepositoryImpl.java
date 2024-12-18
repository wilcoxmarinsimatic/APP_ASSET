package com.cimatic.lector_rfid.infrastructure.repositories;

import com.cimatic.lector_rfid.domain.entities.Auditoria;
import com.cimatic.lector_rfid.domain.ports.AuditoriaRepository;

import java.util.ArrayList;
import java.util.List;

public class AuditoriaRepositoryImpl implements AuditoriaRepository {
//    private final AuditoriaApiAdapter apiAdapter;




    @Override
    public List<Auditoria> getAllAuditorias() {
        // Combinar datos de la API y la base de datos local
        List<Auditoria> auditorias = new ArrayList<>();
        return auditorias;
    }
}

