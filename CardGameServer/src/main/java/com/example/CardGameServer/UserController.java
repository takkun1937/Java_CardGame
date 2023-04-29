package com.example.CardGameServer;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // @Autowired
    // private UserRepository userRepository;

    @GetMapping("/top")
    public String showTop(@ModelAttribute("user") User user, Model model) {
        // userRepository.addAttribute("users", userRepository.findAll());
        return "top";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegister(@ModelAttribute("form") UserForm userForm) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("form") UserForm userForm, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.register(userForm.getUsername(), userForm.getPassword());
        return "redirect:/login";
    }

    // @PostMapping("/search")
    // public String search(@RequestParam("username") String username, Model model)
    // {
    // User user = userRepository.findByUsername(username);
    // model.addAttribute("users", user);
    // return "top";
    // }

}
