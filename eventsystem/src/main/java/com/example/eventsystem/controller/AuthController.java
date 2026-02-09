package com.example.eventsystem.controller;

import com.example.eventsystem.entity.User;
import com.example.eventsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Show Login Page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Show Register Page
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "privacy";
    }

    // Process Registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        // 1. Check if email exists
        if(userRepository.findByEmail(user.getEmail()) != null) {
            return "redirect:/register?error";
        }

        // 2. Encrypt Password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 3. Set Default Role
        user.setRole("ROLE_ADMIN"); // Making the first user ADMIN for testing

        // 4. Save
        userRepository.save(user);

        return "redirect:/login?success";
    }
}