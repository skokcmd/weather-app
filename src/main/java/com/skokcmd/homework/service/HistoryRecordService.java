package com.skokcmd.homework.service;

import com.skokcmd.homework.model.AverageTemperatureRecord;
import com.skokcmd.homework.model.HistoryRecord;

import java.util.List;
import java.util.UUID;

public interface HistoryRecordService {

    void saveRecord(HistoryRecord record);
    List<HistoryRecord> getAllRecords();
    HistoryRecord getRecordById(UUID id);
    List<HistoryRecord> getRecordsByCity(String city);
    List<AverageTemperatureRecord> findAverageTemperaturesByCity(String city);

}
