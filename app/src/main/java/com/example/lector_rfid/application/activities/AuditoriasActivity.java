package com.example.lector_rfid.application.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lector_rfid.R;

public class AuditoriasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_auditoria);

        // Configurar el botón de regresar
        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Regresa a la actividad anterior
            }
        });

        // Configurar la lista de auditorías
        ListView lvAuditorias = findViewById(R.id.lv_auditorias);
        String[] auditorias = {"Auditoría 1", "Auditoría 2", "Auditoría 3", "Auditoría 4"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                auditorias
        );
        lvAuditorias.setAdapter(adapter);

        // Aquí puedes agregar funcionalidad para manejar clics en las auditorías
        lvAuditorias.setOnItemClickListener((parent, view, position, id) -> {
            // Implementar la lógica al seleccionar una auditoría
        });
    }
}
