package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.dtos.UserDTO;
import com.umair.PropertyManagement.model.Role;
import com.umair.PropertyManagement.model.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO UserToUserDTO(User user) {
        if(user == null) return null;

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.joining(",")));

        return userDTO;
    }
}
