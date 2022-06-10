package com.example.springwebshop.service;

import com.example.springwebshop.model.AppUser;
import com.example.springwebshop.model.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getAllUsers();
}
