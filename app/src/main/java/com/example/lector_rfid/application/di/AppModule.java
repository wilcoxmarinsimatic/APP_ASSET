package com.example.lector_rfid.application.di;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

import com.example.lector_rfid.domain.ports.RfidReaderPort;
import com.example.lector_rfid.infrastructure.repositories.RfidReaderRepository;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    public RfidReaderPort provideRfidReader() {
        return new RfidReaderRepository();
    }
}
