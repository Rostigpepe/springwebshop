package com.example.springwebshop.controller;

import com.example.springwebshop.model.AppUser;
import com.example.springwebshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/sign_up")
@RequiredArgsConstructor
public class SignUpController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/api/user/save")
                        .toUriString());

        ResponseEntity<AppUser> responseEntity = ResponseEntity.created(uri).body(userService.saveUser(user));

        userService.addRoleToUser(user.getUsername(), "ROLE_ADMIN");

        return responseEntity;
    }
}
