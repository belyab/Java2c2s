package ru.stud.kpfu.baigulova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stud.kpfu.baigulova.model.Appeal;

import java.util.List;

public interface AppealRepository extends JpaRepository<Appeal, Integer> {
    List<Appeal> getAppealsByUserId(Integer id);

    List<Appeal> getAppealsByWeatherCityIgnoreCase(String city);
}
