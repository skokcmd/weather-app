package com.skokcmd.homework.model;

import java.util.Date;

/**
 * interface pro projekci dat z puvodniho zaznamu do kratsi formy
 *
 * */
public interface AverageTemperatureRecord {
  Date getDatum();

  double getTeplota();
}
