package com.cimatic.lector_rfid.domain.entities;

public class Auditoria {
    private final String name;
    private final int count;

    public Auditoria(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
