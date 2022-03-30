package ru.stud.kpfu.baigulova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.stud.kpfu.baigulova.dto.CreateUserDto;
import ru.stud.kpfu.baigulova.dto.UserDto;
import ru.stud.kpfu.baigulova.helper.PasswordHelper;
import ru.stud.kpfu.baigulova.model.User;
import ru.stud.kpfu.baigulova.repository.UserRepository;
import ru.stud.kpfu.baigulova.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    @ResponseBody
    public Iterable<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserDto get(@PathVariable Integer id) {
        return userService.getById(id);
    }

    public String signUp(@ModelAttribute(name = "user") CreateUserDto userDto, HttpServletRequest request) {
        String url = request.getRequestURL().toString().replace(request.getServletPath(), "");
        userService.save(userDto, url);

        return "sign_up_success";
    }


    @GetMapping("/verification")
    public String verify(@Param("code") String code) {

        if (userService.verify(code)) {
            return "verification_success";
        } else {
            return "verification_failed";
        }
    }

    @GetMapping("/error")
    public String getLoginFail() {
        return "login_fail";
    }
}
