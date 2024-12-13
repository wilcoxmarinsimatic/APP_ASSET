package com.example.lector_rfid.infrastructure.repositories;

import com.example.lector_rfid.domain.entities.Auditoria;
import com.example.lector_rfid.domain.ports.AuditoriaRepository;

import java.util.List;

public class AuditoriaRepositoryImpl implements AuditoriaRepository {
    private final AuditoriaApiAdapter apiAdapter;




    @Override
    public List<Auditoria> getAllAuditorias() {
        // Combinar datos de la API y la base de datos local
    }
}

