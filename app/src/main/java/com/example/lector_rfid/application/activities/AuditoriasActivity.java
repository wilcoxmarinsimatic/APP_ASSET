package com.example.lector_rfid.application.activities;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lector_rfid.R;
import com.example.lector_rfid.application.adapters.AuditoriasAdapter;
import com.example.lector_rfid.domain.entities.Auditoria;

import java.util.Arrays;
import java.util.List;

public class AuditoriasActivity extends AppCompatActivity {

    private static final int REQUEST_NOTIFICATION_PERMISSION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auditorias);

        // Configurar botón de regresar
        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());

        // Configurar RecyclerView con lista de Auditorias
        RecyclerView rvAuditorias = findViewById(R.id.rv_auditorias);
        rvAuditorias.setLayoutManager(new LinearLayoutManager(this));

        // Datos de auditorías con nombre y contador de notificaciones
        List<Auditoria> auditorias = Arrays.asList(
                new Auditoria("Auditoría 1", 5),
                new Auditoria("Auditoría 2", 10),
                new Auditoria("Auditoría 3", 2),
                new Auditoria("Auditoría 4", 0)
        );

        // Configurar adaptador
        AuditoriasAdapter adapter = new AuditoriasAdapter(auditorias);
        rvAuditorias.setAdapter(adapter);

        // Verificar y solicitar el permiso si es necesario
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Android 13+
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS}, REQUEST_NOTIFICATION_PERMISSION);
            } else {
                // Permiso ya otorgado, mostrar notificación
                mostrarNotificacionLocal("Auditorías Actualizadas", "Tienes " + getTotalAuditorias(auditorias) + " auditorías pendientes.");
            }
        } else {
            // En versiones anteriores no se necesita el permiso
            mostrarNotificacionLocal("Auditorías Actualizadas", "Tienes " + getTotalAuditorias(auditorias) + " auditorías pendientes.");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_NOTIFICATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso otorgado, mostrar notificación
                Toast.makeText(this, "Permiso de notificaciones concedido", Toast.LENGTH_SHORT).show();
                // Mostrar notificación con cantidad pendiente
                mostrarNotificacionLocal("Auditorías Actualizadas", "Tienes auditorías pendientes.");
            } else {
                // Permiso denegado
                Toast.makeText(this, "Permiso para notificaciones denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void mostrarNotificacionLocal(String titulo, String mensaje) {
        String CHANNEL_ID = "AUDITORIA_LOCAL";

        // Configurar el canal de notificación
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Actualización de Auditorías",
                    NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }

        // Crear la notificación
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification) // Icono de la notificación
                .setContentTitle(titulo)
                .setContentText(mensaje)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        // Mostrar la notificación
        manager.notify(2, builder.build());
    }

    private int getTotalAuditorias(List<Auditoria> auditorias) {
        int total = 0;
        for (Auditoria auditoria : auditorias) {
            total += auditoria.getCount();
        }
        return total;
    }
}
