package ru.stud.kpfu.baigulova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stud.kpfu.baigulova.dto.AppealDto;
import ru.stud.kpfu.baigulova.model.Appeal;
import ru.stud.kpfu.baigulova.repository.AppealRepository;
import ru.stud.kpfu.baigulova.service.AppealService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppealServiceImpl implements AppealService {

    private final AppealRepository appealRepository;

    @Autowired
    public AppealServiceImpl(AppealRepository appealRepository) {
        this.appealRepository = appealRepository;
    }

    @Override
    public AppealDto save(Appeal appeal) {
        return AppealDto.fromModel(appealRepository.save(appeal));
    }

    @Override
    public List<AppealDto> getAppealsByUserId(Integer id) {
        return appealRepository.getAppealsByUserId(id).stream()
                .map(AppealDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppealDto> getAppealsByWeatherCity(String city) {
        return appealRepository.getAppealsByWeatherCityIgnoreCase(city).stream()
                .map(AppealDto::fromModel)
                .collect(Collectors.toList());
    }
}
