package com.cimatic.lector_rfid.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cimatic.lector_rfid.domain.entities.Auditoria;
import com.cimatic.lector_rfid.domain.usecase.GetAuditoriasUseCase;

import java.util.List;

public class AuditoriasViewModel extends ViewModel {
    private final GetAuditoriasUseCase useCase;
    private final MutableLiveData<List<Auditoria>> auditorias = new MutableLiveData<>();

    public AuditoriasViewModel(GetAuditoriasUseCase useCase) {
        this.useCase = useCase;
    }

    public LiveData<List<Auditoria>> getAuditorias() {
        return auditorias;
    }

    public void fetchAuditorias() {
      //  auditorias.postValue(useCase.execute());
    }
}
