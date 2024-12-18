package com.cimatic.lector_rfid.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cimatic.lector_rfid.domain.entities.User;
import com.cimatic.lector_rfid.domain.usecase.LoginUseCase;

public class LoginViewModel extends ViewModel {

    private final LoginUseCase loginUseCase;
    private final MutableLiveData<User> userLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public LoginViewModel(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    public LiveData<User> getUserLiveData() {
        return userLiveData;
    }

    public LiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public void login(String email, String password) {
        try {
            User user = loginUseCase.execute(email, password);
            userLiveData.postValue(user);
        } catch (Exception e) {
            errorLiveData.postValue(e.getMessage());
        }
    }
}
