package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.dto.RoleDTO;
import com.umair.PropertyManagement.dto.UserDTO;
import com.umair.PropertyManagement.model.Role;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.repository.RoleRepository;

import java.util.Set;

public class UserMapper {

    public static UserDTO UserToUserDTO(User user) {
        if (user == null) return null;

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setRoles(RoleMapper.RoleToRoleDTO(user.getRoles()).getRole());
        return userDTO;
    }

    public static User UserDTOToUser(UserDTO userDTO, RoleRepository roleRepository) {
        if (userDTO == null) return null;

        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());

        Set<Role> roles = RoleMapper.RoleDTOToRole(new RoleDTO(userDTO.getRoles()), roleRepository);

        user.setRoles(roles);

        return user;
    }


}
