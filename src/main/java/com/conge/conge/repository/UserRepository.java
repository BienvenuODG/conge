package com.conge.conge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conge.conge.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    User findByEmailAndPassword(String email, String password);
}

