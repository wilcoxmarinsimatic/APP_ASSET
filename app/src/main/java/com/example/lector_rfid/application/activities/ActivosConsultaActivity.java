package com.example.lector_rfid.application.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lector_rfid.R;
import com.example.lector_rfid.application.adapters.ActivoAdapter;

import java.util.ArrayList;
import java.util.List;

public class ActivosConsultaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_activos);

        RecyclerView rvActivos = findViewById(R.id.rv_activos);
        rvActivos.setLayoutManager(new LinearLayoutManager(this));

        List<ActivoAdapter.Activo> activos = new ArrayList<>();
        activos.add(new ActivoAdapter.Activo("123", "Computadora", "Laptop", "Juan", "Electrónica", "Oficina", "Activo"));
        activos.add(new ActivoAdapter.Activo("124", "Impresora", "LaserJet", "María", "Electrónica", "Almacén", "Inactivo"));

        ActivoAdapter adapter = new ActivoAdapter(activos);
        rvActivos.setAdapter(adapter);
    }
}
