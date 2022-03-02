package ru.stud.kpfu.baigulova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.stud.kpfu.baigulova.dto.CreateUserDto;
import ru.stud.kpfu.baigulova.dto.UserDto;
import ru.stud.kpfu.baigulova.helper.PasswordHelper;
import ru.stud.kpfu.baigulova.model.User;
import ru.stud.kpfu.baigulova.repository.UserRepository;
import ru.stud.kpfu.baigulova.service.UserService;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public Iterable<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public UserDto get(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PostMapping("/user")
    public UserDto createUser(@Valid @RequestBody CreateUserDto user) {
        return userService.save(user);
    }
}
