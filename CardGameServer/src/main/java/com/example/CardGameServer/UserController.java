package com.example.CardGameServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import com.example.CardGameServer.UserForm;
//import com.example.CardGameServer.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/registerLogin")
    public String showRegisterLogin() {
        return "user/registerLogin";
    }

    @PostMapping("/user/registerLogin")
    public String register(UserForm userForm) {
        userService.register(userForm.getUsername(), userForm.getPassword());
        return "redirect:/user/top";
    }

    @PostMapping("/login")
    public String showLoginPage() {
        return "redirect:/user/top";
    }

    @GetMapping("/user/top")
    public String showTopPage() {
        return "user/top";
    }
}
