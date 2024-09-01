package com.umair.PropertyManagement.implementation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umair.PropertyManagement.Enums.RoleType;
import com.umair.PropertyManagement.dtos.UserDTO;
import com.umair.PropertyManagement.model.Role;
import com.umair.PropertyManagement.repository.RoleRepository;
import com.umair.PropertyManagement.services.InitializationService;
import com.umair.PropertyManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitializationServiceImplementation implements InitializationService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserService userService;

    public void initialize() {
        try {
            createDefaultRoleIfNotExists();
            loadUsers();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createDefaultRoleIfNotExists() {

        List<Role> roles = new ArrayList<>();
        roles.add(new Role(RoleType.ADMIN));
        roles.add(new Role(RoleType.AGENT));
        roles.add(new Role(RoleType.BUYER));
        roles.add(new Role(RoleType.SELLER));

        for (Role role : roles) {
            if (roleRepository.findByName(role.getName()) == null) {
                roleRepository.save(role);
            }
        }
    }


    private void loadUsers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<UserDTO> users = objectMapper.readValue(
                new ClassPathResource("users.json").getInputStream(),
                new TypeReference<List<UserDTO>>() {}
        );
        users.forEach(user -> userService.createUser(user));
    }

}
