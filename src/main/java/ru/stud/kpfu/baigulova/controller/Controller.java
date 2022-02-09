package ru.stud.kpfu.baigulova.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stud.kpfu.baigulova.service.Service;

import java.io.IOException;
import java.util.Optional;

@RestController
public class Controller {
    private Service service  = new Service();

    @GetMapping("/weather")
    public String hello(@RequestParam Optional<String> city) throws IOException {
        String result = service.get(city.orElse("Kazan"));
        return result;
    }
}


