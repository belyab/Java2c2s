package ru.stud.kpfu.baigulova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stud.kpfu.baigulova.dto.WeatherDto;
import ru.stud.kpfu.baigulova.model.Weather;
import ru.stud.kpfu.baigulova.repository.WeatherRepository;
import ru.stud.kpfu.baigulova.service.WeatherService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public List<WeatherDto> findAll() {
        return weatherRepository.findAll().stream()
                .map(WeatherDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public WeatherDto save(Weather weather) {
        return null;
    }

    @Override
    public List<WeatherDto> getWeathersByCity(String city) {
        return weatherRepository.getWeathersByCityIgnoreCase(city).stream()
                .map(WeatherDto::fromModel)
                .collect(Collectors.toList());
    }
}
