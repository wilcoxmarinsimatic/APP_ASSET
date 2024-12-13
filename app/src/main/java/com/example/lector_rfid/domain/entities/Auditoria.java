package com.example.lector_rfid.domain.entities;


public class Auditoria {
    private final String name;
    private final int pendingTasks;

    public Auditoria(String name, int pendingTasks) {
        this.name = name;
        this.pendingTasks = pendingTasks;
    }

    public String getName() {
        return name;
    }

    public int getPendingTasks() {
        return pendingTasks;
    }
}


