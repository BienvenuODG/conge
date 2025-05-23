package com.conge.conge.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.conge.conge.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
    boolean existsByName(String name);
}
