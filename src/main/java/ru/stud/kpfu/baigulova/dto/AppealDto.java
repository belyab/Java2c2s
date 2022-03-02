package ru.stud.kpfu.baigulova.dto;

import ru.stud.kpfu.baigulova.model.Appeal;

public class AppealDto {

    private Integer id;
    private String date;
    private WeatherDto weather;
    private UserDto userDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WeatherDto getWeather() {
        return weather;
    }

    public void setWeather(WeatherDto weather) {
        this.weather = weather;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public AppealDto(Integer id, String date, WeatherDto weather, UserDto userDto) {
        this.id = id;
        this.date = date;
        this.weather = weather;
        this.userDto = userDto;
    }

    public static AppealDto fromModel(Appeal appeal) {
        return new AppealDto(appeal.getId(), appeal.getDate(), WeatherDto.fromModel(appeal.getWeather()),
                UserDto.fromModel(appeal.getUser()));
    }
}
