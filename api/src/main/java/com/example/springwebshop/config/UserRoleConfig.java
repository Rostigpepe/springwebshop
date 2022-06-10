package com.example.springwebshop.config;

import com.example.springwebshop.model.AppUser;
import com.example.springwebshop.model.Role;
import com.example.springwebshop.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class UserRoleConfig {

    @Bean
    CommandLineRunner userAndRoleCreation(UserService service){
        return args ->{

            service.saveRole(new Role(null, "ROLE_USER"));
            service.saveRole(new Role(null, "ROLE_MANAGER"));
            service.saveRole(new Role(null, "ROLE_ADMIN"));
            service.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            service.saveUser(new AppUser(
                    null,
                    "Robin",
                    "Robin",
                    "123",
                    new ArrayList<>()
            ));

            service.saveUser(new AppUser(
                    null,
                    "Erin",
                    "Erin",
                    "123",
                    new ArrayList<>()
            ));

            service.saveUser(new AppUser(
                    null,
                    "Linus",
                    "Linus",
                    "123",
                    new ArrayList<>()
            ));

            service.addRoleToUser("Robin", "ROLE_ADMIN");
            service.addRoleToUser("Erin", "ROLE_ADMIN");
            service.addRoleToUser("Linus", "ROLE_ADMIN");

        };
    }

}
