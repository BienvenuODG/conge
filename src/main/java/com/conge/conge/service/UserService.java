package com.conge.conge.service;

import java.util.List;
import com.conge.conge.model.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conge.conge.repository.RoleRepository;
import com.conge.conge.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    // private RoleRepository roleRepository;

    public List<User> findAll() { return userRepository.findAll(); }
    public User findById(Long id) { return userRepository.findById(id).orElse(null); }
    public void save(com.conge.conge.model.User user) { userRepository.save(user); }
    public void delete(Long id) { userRepository.deleteById(id); }
}