package ru.stud.kpfu.baigulova.service;

import ru.stud.kpfu.baigulova.dto.AppealDto;
import ru.stud.kpfu.baigulova.model.Appeal;

import java.util.List;

public interface AppealService {

    AppealDto save(Appeal appeal);

    List<AppealDto> getAppealsByUserId(Integer id);

    List<AppealDto> getAppealsByWeatherCity(String city);
}
