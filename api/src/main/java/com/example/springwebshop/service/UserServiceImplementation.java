package com.example.springwebshop.service;

import com.example.springwebshop.model.AppUser;
import com.example.springwebshop.model.Role;
import com.example.springwebshop.repository.RoleRepo;
import com.example.springwebshop.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImplementation implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Gets user from repo
        AppUser user = userRepo.findByUsername(username);

        //Logging and throwing error in case of no user found
        if(user == null){
            log.error("User {} not found in DB", username);
            throw new UsernameNotFoundException("User not found in DB");
        }
        else{
            log.info("User found in DB {}", username);
        }

        //Granting authorities to the user we just loaded in based on their roles
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        //Returning the user as a spring security user
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("saving new user {} to the database", user.getName());
        //Encoding the user password so it isn't stored raw
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        AppUser user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);

        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getAllUsers() {
        log.info("fetching all users");
        return userRepo.findAll();
    }

}
