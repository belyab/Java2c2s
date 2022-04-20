package ru.stud.kpfu.baigulova.controller;

import org.springframework.stereotype.Controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.stud.kpfu.baigulova.dto.UserDto;

import java.util.Optional;

@Controller
public class HelloController {

    @Operation(summary = "Returns index view")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "View was get",
            content = {@Content(mediaType = "text/html")})})
    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam Optional<String> name) {
        return String.format("Hello, %s!", name.orElse("name"));
    }

    @GetMapping("")
    public String getIndexPage() {
        return "index";
    }

    @Operation(summary = "Returns sign up view")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "View was get",
            content = {@Content(mediaType = "text/html")})})
    @GetMapping("/sign_up")
    public String getSignUp(Model model) {
        model.addAttribute("user", new UserDto());
        return "sign_up";
    }

    @Operation(summary = "Returns home view")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "View was get",
            content = {@Content(mediaType = "text/html")})})
    @GetMapping("/home")
    public String getHome() {
        return "home";
    }
}

