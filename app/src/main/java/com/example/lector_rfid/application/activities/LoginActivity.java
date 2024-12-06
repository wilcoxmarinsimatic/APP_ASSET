package com.example.lector_rfid.application.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.lector_rfid.R;
import com.example.lector_rfid.application.di.AppModule;
import com.example.lector_rfid.application.viewmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory())
                .get(LoginViewModel.class);
        loginViewModel = new LoginViewModel(AppModule.provideLoginUseCase());

        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            loginViewModel.login(email, password);
        });

        loginViewModel.getUserLiveData().observe(this, user -> {
            Toast.makeText(this, "Bienvenido " + user.getName(), Toast.LENGTH_SHORT).show();
        });

        loginViewModel.getErrorLiveData().observe(this, error -> {
            Toast.makeText(this, "Error: " + error, Toast.LENGTH_SHORT).show();
        });
    }
}

