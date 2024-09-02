package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();
    UserDTO findUserById(Long userId);
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user);
    Boolean deleteUser(Long userId);

    UserDTO addRoleForUser(Long userId, String rolename);
    UserDTO deleteRoleFromUser(Long userId, String rolename);
}
