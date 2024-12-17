package com.example.lector_rfid.application.activities;


import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lector_rfid.R;

public class DetalleAuditoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_auditoria);

        // Obtener datos pasados desde AuditoriasActivity
        String auditoriaName = getIntent().getStringExtra("AUDITORIA_NAME");

        // Configurar el título y detalle
        TextView tvTitle = findViewById(R.id.tv_auditoria_title);
        TextView tvDetail = findViewById(R.id.tv_auditoria_detail);

        tvTitle.setText(auditoriaName);
        tvDetail.setText("Detalles completos de " + auditoriaName);

        // Configurar el botón de regresar
        ImageButton btnBack = findViewById(R.id.btn_back_detail);
        btnBack.setOnClickListener(v -> finish());
    }
}

