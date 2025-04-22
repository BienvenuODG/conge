package com.conge.conge.service.flutter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conge.conge.model.User;
import com.conge.conge.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password)) // ⚠ à sécuriser plus tard
                .orElseThrow(() -> new RuntimeException("Identifiants invalides"));
    }
}
