package com.example.lector_rfid.application.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lector_rfid.R;
import com.example.lector_rfid.application.adapters.ActivoAdapter;
import com.example.lector_rfid.infrastructure.api.ActivoApi;
import com.example.lector_rfid.infrastructure.api.ActivoService;
import com.example.lector_rfid.infrastructure.database.AppDatabase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivosConsultaActivity extends AppCompatActivity {

    private List<ActivoAdapter.Activo> activos = new ArrayList<>();
    private ActivoAdapter adapter;

    private EditText etCodigoRFID;
    private EditText etNombreActivo;

    private static final int PAGE_SIZE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_activos);

        // Inicializar RecyclerView
        RecyclerView rvActivos = findViewById(R.id.rv_activos);
        rvActivos.setLayoutManager(new LinearLayoutManager(this));

        // Configurar el adaptador
        adapter = new ActivoAdapter(activos);
        rvActivos.setAdapter(adapter);

        // Inicializar filtros y botón
        Button btnBuscar = findViewById(R.id.btn_buscar_activo);
        etCodigoRFID = findViewById(R.id.et_codigo_rfid);
        etNombreActivo = findViewById(R.id.et_nombre_activo);

        // Configurar el botón de búsqueda
        btnBuscar.setOnClickListener(v -> {
            String filtroCodigo = etCodigoRFID.getText().toString().trim();
            String filtroNombre = etNombreActivo.getText().toString().trim();
            cargarActivosDesdeApi(filtroCodigo, filtroNombre, 1);
        });

        // Cargar datos locales al iniciar
        mostrarCacheLocal();
    }

    // Método para cargar activos desde el API
    private void cargarActivosDesdeApi(String codigoRFID, String nombreActivo, int page) {
        ActivoApi api = ActivoService.getActivoApi();

        Call<List<ActivoAdapter.Activo>> call = api.getActivos(codigoRFID, nombreActivo, page, PAGE_SIZE);
        call.enqueue(new Callback<List<ActivoAdapter.Activo>>() {
            @Override
            public void onResponse(Call<List<ActivoAdapter.Activo>> call, Response<List<ActivoAdapter.Activo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ActivoAdapter.Activo> nuevosActivos = response.body();
                    adapter.updateList(nuevosActivos);

                    // Guardar en la base de datos local
                    guardarEnCacheLocal(nuevosActivos);
                } else {
                    Toast.makeText(ActivosConsultaActivity.this, "No se encontraron datos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ActivoAdapter.Activo>> call, Throwable t) {
                Log.e("API", "Error: " + t.getMessage());
                Toast.makeText(ActivosConsultaActivity.this, "Error al conectar con el servidor. Mostrando datos locales.", Toast.LENGTH_SHORT).show();
                mostrarCacheLocal();
            }
        });
    }

    // Método para guardar datos localmente
    private void guardarEnCacheLocal(List<ActivoAdapter.Activo> activos) {
        new Thread(() -> {
            AppDatabase db = AppDatabase.getDatabase(getApplicationContext());
            db.activoDao().insertAll(activos);
        }).start();
    }

    // Método para cargar datos desde la base local
    private void mostrarCacheLocal() {
        new Thread(() -> {
            AppDatabase db = AppDatabase.getDatabase(getApplicationContext());
            List<ActivoAdapter.Activo> activosLocales = db.activoDao().getActivosByCodigo("");
            runOnUiThread(() -> adapter.updateList(activosLocales));
        }).start();
    }
}
