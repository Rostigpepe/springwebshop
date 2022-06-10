package com.example.springwebshop.controller;

import com.example.springwebshop.model.AppUser;
import com.example.springwebshop.model.Role;
import com.example.springwebshop.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    //!!!!! THIS IS JUST A LEFTOVER CLASS FROM THE PROJECT WHERE I TESTED SECURITY !!!!!
    //!!!!! THIS IS JUST A LEFTOVER CLASS FROM THE PROJECT WHERE I TESTED SECURITY !!!!!
    //!!!!! THIS IS JUST A LEFTOVER CLASS FROM THE PROJECT WHERE I TESTED SECURITY !!!!!

    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<AppUser>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/api/user/save")
                        .toUriString());

        ResponseEntity<AppUser> responseEntity = ResponseEntity.created(uri).body(userService.saveUser(user));

        userService.addRoleToUser(user.getUsername(), "ROLE_ADMIN");

        return responseEntity;
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/api/role/save")
                        .toUriString());

        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

}

@Data
class RoleToUserForm{
    private String username;
    private String roleName;
}
