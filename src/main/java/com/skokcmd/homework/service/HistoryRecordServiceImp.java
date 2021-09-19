package com.skokcmd.homework.service;

import com.skokcmd.homework.model.AverageTemperatureRecord;
import com.skokcmd.homework.model.HistoryRecord;
import com.skokcmd.homework.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HistoryRecordServiceImp implements HistoryRecordService {

  @Autowired HistoryRepository historyRepository;

  /**
   * uloží záznam do historie
   *
   * @param record záznam hledání
   */
  @Override
  public void saveRecord(HistoryRecord record) {
    historyRepository.save(record);
  }

  /**
   * vrátí seznam všech záznamů
   *
   * @return List záznamů
   */
  @Override
  public List<HistoryRecord> getAllRecords() {
    return historyRepository.findAll();
  }

  /**
   * Najde záznam podle id
   *
   * @param id id záznamu
   * @return záznam || null
   */
  @Override
  public HistoryRecord getRecordById(UUID id) {
    return historyRepository.findById(id).orElse(null);
  }

  /**
   * Najde list zaznamu pro dane mesto
   *
   * @param city mesto
   * @return List zaznamu
   * */
  @Override
  public List<HistoryRecord> getRecordsByCity(String city) {
    return historyRepository.listOfRecordsByCity(city);
  }

  /**
   * Seznam zaznamu pro zobrazeni data a avg teploty u daneho mesta (viz interface)
   *
   * @param city mesto
   * @return zaznamy s daty a avg teplotou
   * */
  @Override
  public List<AverageTemperatureRecord> findAverageTemperaturesByCity(String city) {
    return historyRepository.averageTemperaturesByCity(city);
  }
}
