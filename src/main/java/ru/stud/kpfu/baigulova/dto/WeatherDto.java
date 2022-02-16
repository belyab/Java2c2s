package ru.stud.kpfu.baigulova.dto;

import ru.stud.kpfu.baigulova.model.Weather;

public class WeatherDto {
    private Integer id;
    private String description;
    private String humidity;
    private String temp;
    private String city;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public WeatherDto(Integer id, String description, String humidity, String temp, String city, String email) {
        this.id = id;
        this.description = description;
        this.humidity = humidity;
        this.temp = temp;
        this.city = city;
        this.email = email;
    }

    public static WeatherDto fromModel(Weather weather) {
        return new WeatherDto(weather.getId(), weather.getDescription(), weather.getHumidity(),
                weather.getTemp(), weather.getCity(), weather.getEmail());
    }
}
