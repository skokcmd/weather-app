package com.skokcmd.homework.repository;

import com.skokcmd.homework.model.AverageTemperatureRecord;
import com.skokcmd.homework.model.HistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface HistoryRepository extends JpaRepository<HistoryRecord, UUID> {
  // custom query na ziskani seznamu zaznamu pro dane mesto
  @Query(value = "SELECT * FROM historie WHERE mesto = ?1", nativeQuery = true)
  List<HistoryRecord> listOfRecordsByCity(String city);

  // custom query na ziskani prumerne teploty pro kazde datum, pouziti projekce
  @Query(
      "SELECT r.datum as datum, AVG(r.teplota) as teplota FROM HistoryRecord r WHERE mesto=?1 GROUP BY r.datum")
  List<AverageTemperatureRecord> averageTemperaturesByCity(String city);
}
