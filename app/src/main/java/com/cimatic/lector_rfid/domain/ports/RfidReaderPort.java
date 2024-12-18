package com.cimatic.lector_rfid.domain.ports;

import java.util.List;

public interface RfidReaderPort {
    void initializeReader();
    void startReading();
    void stopReading();
    List<String> getTags();
}
