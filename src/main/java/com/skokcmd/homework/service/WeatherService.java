package com.skokcmd.homework.service;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

  private final OpenWeatherMapClient openWeatherClient =
      new OpenWeatherMapClient("9f22fb91f6b670fd083a7e74ea8922aa");

  /**
   * Vrati teplotu podle mesta
   *
   * @param city mesto
   * @return teplota
   *
   * */
  public double getTemperatureByCity(String city) {
    return openWeatherClient
        .currentWeather()
        .single()
        .byCityName(city)
        .language(Language.CZECH)
        .unitSystem(UnitSystem.METRIC)
        .retrieve()
        .asJava()
        .getTemperature()
        .getValue();
  }
}
