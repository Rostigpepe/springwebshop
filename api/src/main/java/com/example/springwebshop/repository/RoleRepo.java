package com.example.springwebshop.repository;

import com.example.springwebshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String username);
}
