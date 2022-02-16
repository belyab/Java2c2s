package ru.stud.kpfu.baigulova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.stud.kpfu.baigulova.dto.CreateUserDto;
import ru.stud.kpfu.baigulova.dto.UserDto;
import ru.stud.kpfu.baigulova.helper.PasswordHelper;
import ru.stud.kpfu.baigulova.model.User;
import ru.stud.kpfu.baigulova.repository.UserRepository;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public Iterable<UserDto> getAll() {
        return userRepository.findAll().stream().map(UserDto::fromModel).collect(Collectors.toList());
    }

    @GetMapping("/user/{id}")
    public UserDto get(@PathVariable Integer id) {
        return userRepository.findById(id).stream().map(UserDto::fromModel).findFirst().orElse(null);
    }

    @PostMapping("/user")
    public UserDto createUser(@Valid @RequestBody CreateUserDto user) {
        return UserDto.fromModel(userRepository.save(new User(user.getName(), user.getEmail(),
                PasswordHelper.encrypt(user.getPassword()))));
    }
}
