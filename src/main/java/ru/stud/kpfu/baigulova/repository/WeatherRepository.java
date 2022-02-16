package ru.stud.kpfu.baigulova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stud.kpfu.baigulova.model.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}
