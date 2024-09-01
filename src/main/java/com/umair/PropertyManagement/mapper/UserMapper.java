package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.Enums.RoleType;
import com.umair.PropertyManagement.dtos.UserDTO;
import com.umair.PropertyManagement.model.Role;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.repository.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO UserToUserDTO(User user) {
        if (user == null) return null;

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setRoles(user.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.joining(",")));
        return userDTO;
    }

    public static User UserDTOToUser(UserDTO userDTO, RoleRepository roleRepository) {
        if (userDTO == null) return null;

        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());

        Set<Role> roles = Arrays.stream(userDTO.getRoles().split(","))
                .map(String::trim)
                .map(roleName -> {
                    Role role = roleRepository.findByName(RoleType.valueOf(roleName.toUpperCase()));
                    if (role == null) {
                        throw new IllegalArgumentException("Invalid role type: " + roleName);
                    }
                    return role;
                })
                .collect(Collectors.toSet());

        user.setRoles(roles);

        return user;
    }


}
