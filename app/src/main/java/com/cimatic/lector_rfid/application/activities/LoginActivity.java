package com.cimatic.lector_rfid.application.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cimatic.lector_rfid.R;
import com.cimatic.lector_rfid.application.di.AppModule;
import com.cimatic.lector_rfid.application.di.MainActivity;
import com.cimatic.lector_rfid.application.utils.SessionManager;
import com.cimatic.lector_rfid.domain.entities.User;
import com.cimatic.lector_rfid.domain.usecase.LoginUseCase;

public class LoginActivity extends AppCompatActivity {

    private LoginUseCase loginUseCase;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar el caso de uso y el SessionManager
        loginUseCase = AppModule.provideLoginUseCase();
        sessionManager = new SessionManager(this);

        // Verificar si ya hay una sesión activa
        if (sessionManager.isLoggedIn()) {
            redirectToMenu();
            return; // Salir para evitar que se ejecute el resto del código
        }

        // Referencias a los elementos de la interfaz
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);

        // Configurar el botón de inicio de sesión
        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                User user = loginUseCase.execute(email, password);
                if (user != null && user.getId() != null) {
                    sessionManager.saveLoginSession(user.getToken());
                    redirectToMenu();
                } else {
                    Toast.makeText(this, "Inicio de sesión fallido.", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void redirectToMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}