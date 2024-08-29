package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.model.Role;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.repository.RoleRepository;
import com.umair.PropertyManagement.repository.UserRepository;
import com.umair.PropertyManagement.services.InitializationService;
import com.umair.PropertyManagement.services.RoleService;
import com.umair.PropertyManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializationServiceImplementation implements InitializationService {

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    public void initialize() {
        createDefaultRoleIfNotExists();
        createDefaultUserAtStart();
    }

    private void createDefaultRoleIfNotExists() {
        if (roleService.findRoleByName("USER") == null) {
            Role defaultRole = new Role();
            defaultRole.setName("USER");
            roleService.createRole(defaultRole);
        }
    }

    private void createDefaultUserAtStart() {
        User user = new User();
        user.setUsername("user");
        user.setEmail("user@test.com");
        user.setPassword("123");

        userService.createUser(user);
    }

}
