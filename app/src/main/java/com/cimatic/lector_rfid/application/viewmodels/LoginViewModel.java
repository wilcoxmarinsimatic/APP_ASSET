package com.cimatic.lector_rfid.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cimatic.lector_rfid.domain.entities.User;
import com.cimatic.lector_rfid.domain.usecase.LoginUseCase;

public class LoginViewModel extends ViewModel {

    private final LoginUseCase loginUseCase;

    private final MutableLiveData<LoginState> loginStateLiveData = new MutableLiveData<>();

    public LoginViewModel(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    public LiveData<LoginState> getLoginStateLiveData() {
        return loginStateLiveData;
    }

    public void login(String email, String password) {
        loginStateLiveData.postValue(LoginState.loading()); // Emitimos un estado de carga

        loginUseCase.execute(email, password)
                .thenAccept(user -> {
                    if (user != null) {
                        loginStateLiveData.postValue(LoginState.success(user)); // Emitimos éxito
                    } else {
                        loginStateLiveData.postValue(LoginState.error("Inicio de sesión fallido."));
                    }
                })
                .exceptionally(e -> {
                    loginStateLiveData.postValue(LoginState.error(e.getMessage())); // Emitimos error
                    return null;
                });
    }

    // Clase para representar el estado de la vista
    public static class LoginState {
        public final boolean isLoading;
        public final User user;
        public final String error;

        private LoginState(boolean isLoading, User user, String error) {
            this.isLoading = isLoading;
            this.user = user;
            this.error = error;
        }

        public static LoginState loading() {
            return new LoginState(true, null, null);
        }

        public static LoginState success(User user) {
            return new LoginState(false, user, null);
        }

        public static LoginState error(String error) {
            return new LoginState(false, null, error);
        }
    }
}
