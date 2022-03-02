package ru.stud.kpfu.baigulova.service;


import ru.stud.kpfu.baigulova.dto.CreateUserDto;
import ru.stud.kpfu.baigulova.dto.UserDto;
import ru.stud.kpfu.baigulova.model.User;

import java.util.List;

public interface UserService {
    User getByEmail(String email);

    UserDto getById(Integer id);

    List<UserDto> getAll();

    UserDto save(CreateUserDto createUserDto);
}
