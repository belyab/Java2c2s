package ru.stud.kpfu.baigulova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stud.kpfu.baigulova.dto.UserDto;
import ru.stud.kpfu.baigulova.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    UserDto findByEmail(String email);
}
