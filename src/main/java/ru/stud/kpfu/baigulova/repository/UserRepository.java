package ru.stud.kpfu.baigulova.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.stud.kpfu.baigulova.dto.UserDto;
import ru.stud.kpfu.baigulova.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    UserDto findByEmail(String email);

    User getUserByEmail(String email);

    @Query("select u from User u where u.name = 'Stepan'")
    List<User> findAllStepanUser();

    @Query(value = "select * from users u where u.name like ?1", nativeQuery = true)
    List<User> findAllByName(String name);

    Page<User> findAll(Pageable pageable);

    @Query(value = "select u from User u where u.name = :name and u.id = :id")
    User findUserByNameAndId(@Param("name") String name, @Param("id") String id);

    @Query(value = "select u from User u where u.id in :ids")
    List<User> findAllByIds(@Param("ids") List<Integer> ids);
}
