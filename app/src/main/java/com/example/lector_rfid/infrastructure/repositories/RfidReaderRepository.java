package com.example.lector_rfid.infrastructure.repositories;

import com.example.lector_rfid.domain.ports.RfidReaderPort;

import java.util.ArrayList;
import java.util.List;

public class RfidReaderRepository implements RfidReaderPort {

    private List<String> tags = new ArrayList<>();

    @Override
    public void initializeReader() {
        // Lógica para inicializar el lector
        System.out.println("RFID Reader initialized.");
    }

    @Override
    public void startReading() {
        // Lógica para comenzar a leer etiquetas RFID
        System.out.println("RFID Reader started reading.");
        // Agrega datos simulados (opcional)
        tags.add("TAG-001");
        tags.add("TAG-002");
    }

    @Override
    public void stopReading() {
        // Lógica para detener la lectura
        System.out.println("RFID Reader stopped reading.");
    }

    @Override
    public List<String> getTags() {
        // Devuelve la lista de etiquetas leídas
        return tags;
    }
}
