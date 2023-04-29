package com.example.CardGameServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public void register(String username, String password) {
        String hashedPassword = passwordEncoder.encode(password);
        userRepository.saveAndFlush(new User(username, hashedPassword, "GENERAL"));
    }
}
