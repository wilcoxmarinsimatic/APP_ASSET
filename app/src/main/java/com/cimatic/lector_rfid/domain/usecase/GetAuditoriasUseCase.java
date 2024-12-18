package com.cimatic.lector_rfid.domain.usecase;

import com.cimatic.lector_rfid.domain.entities.Auditoria;
import com.cimatic.lector_rfid.domain.ports.AuditoriaRepository;

import java.util.ArrayList;
import java.util.List;

public class GetAuditoriasUseCase {
    private final AuditoriaRepository repository;

    public GetAuditoriasUseCase(AuditoriaRepository repository) {
        this.repository = repository;
    }

    public List<Auditoria> execute() {
        //return repository.getAllAuditorias();
        List<Auditoria> auditorias = new ArrayList<>();
        return auditorias;
    }
}
