package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {

    final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userService) {
        this.userRepository = userService;
    }

    @GetMapping("/user")
    public String usersPage(Model model, Principal principal) {
        User user = (User) userRepository.findByUsername(principal.getName()).orElse(null);
        model.addAttribute("userInfo", user);
        return "users/user_page";
    }
}
