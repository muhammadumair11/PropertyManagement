package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.dtos.UserDTO;
import com.umair.PropertyManagement.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();
    UserDTO findUserById(Long userId);
    UserDTO createUser(User user);
    UserDTO updateUser(User user);
    Boolean deleteUser(Long userId);
}
