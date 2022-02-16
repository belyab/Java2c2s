package ru.stud.kpfu.baigulova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stud.kpfu.baigulova.dto.UserDto;
import ru.stud.kpfu.baigulova.dto.WeatherDto;
import ru.stud.kpfu.baigulova.helper.JsonHelper;
import ru.stud.kpfu.baigulova.model.Weather;
import ru.stud.kpfu.baigulova.repository.UserRepository;
import ru.stud.kpfu.baigulova.repository.WeatherRepository;
import ru.stud.kpfu.baigulova.service.HttpService;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class WeatherController {
    private HttpService httpService = new HttpService();
    private final static JsonHelper jsonHelper = new JsonHelper();
    private final UserRepository userRepository;
    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherController(UserRepository userRepository, WeatherRepository weatherRepository) {
        this.userRepository = userRepository;
        this.weatherRepository = weatherRepository;
    }

    @GetMapping("/allWeather")
    public Iterable<WeatherDto> getAll() {
        return weatherRepository.findAll().stream().map(WeatherDto::fromModel).collect(Collectors.toList());
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam Optional<String> city, @RequestParam String email) throws IOException {

        UserDto userDto = userRepository.findByEmail(email);

        if (userDto != null) {
            String result = httpService.get(city.orElse("Kazan"));

            Map<String, String> params = jsonHelper.parseJson(result);
            weatherRepository.save(new Weather(params.get("description"), params.get("humidity"), params.get("temp"), params.get("name"), email));
            return result;
        } else {
            return "null";
        }
    }
}


