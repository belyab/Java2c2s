package ru.stud.kpfu.baigulova.service;

import ru.stud.kpfu.baigulova.dto.WeatherDto;
import ru.stud.kpfu.baigulova.model.Weather;

import java.util.List;

public interface WeatherService {
    List<WeatherDto> findAll();

    WeatherDto save(Weather weather);

    List<WeatherDto> getWeathersByCity(String city);
}
