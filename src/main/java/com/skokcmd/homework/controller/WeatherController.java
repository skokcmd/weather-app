package com.skokcmd.homework.controller;

import com.skokcmd.homework.model.HistoryRecord;
import com.skokcmd.homework.service.HistoryRecordServiceImp;
import com.skokcmd.homework.service.WeatherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WeatherController {

  @Autowired private WeatherServiceImp weatherService;
  @Autowired private HistoryRecordServiceImp historyRecordService;

  @GetMapping("/")
  public String viewCityDetails(Model model) {
    return "index";
  }

  @PostMapping("/saveRecord")
  public String saveRecord(@RequestParam("city") String city, RedirectAttributes redirectAttrs) {
    // vytvori novy zaznam v db o hledani
    historyRecordService.saveRecord(
        new HistoryRecord(city, weatherService.getTemperatureByCity(city)));

    // predani attributu na redirected url
    redirectAttrs.addFlashAttribute("temp", weatherService.getTemperatureByCity(city));
    redirectAttrs.addFlashAttribute(
        "records", historyRecordService.findAverageTemperaturesByCity(city));
    redirectAttrs.addFlashAttribute("city", city);
    return "redirect:/";
  }
}
