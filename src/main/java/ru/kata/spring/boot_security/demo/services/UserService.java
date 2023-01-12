package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findUserById(Long id);

    List<User> allUsers();

    boolean saveUser(User user);

    boolean deleteUserById(Long id);

    void updateUserById(Long id,User user);

    void saveUser(Role role);

    void saveUser(User user, Role role);

    boolean contains(String username);
}
