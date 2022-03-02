package ru.stud.kpfu.baigulova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stud.kpfu.baigulova.model.Weather;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    List<Weather> getWeathersByCityIgnoreCase(String city);
}
