package ru.stud.kpfu.baigulova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.stud.kpfu.baigulova.dto.UserDto;

import java.util.Optional;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam Optional<String> name) {
        return String.format("Hello, %s!", name.orElse("name"));
    }

    @GetMapping("")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/sign_up")
    public String getSignUp(Model model) {
        model.addAttribute("user", new UserDto());
        return "sign_up";
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }
}

