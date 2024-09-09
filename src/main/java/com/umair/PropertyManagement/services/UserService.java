package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();
    UserDTO findUserById(Long userId);
    User findUserByUsername(String username);
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user);
    Boolean deleteUser(Long userId);

    UserDTO addRoleForUser(Long userId, String rolename);
    UserDTO deleteRoleFromUser(Long userId, String rolename);

    User addFavoriteProperty(Long userId, Long propertyId);
    User removeFavoriteProperty(Long userId, Long propertyId);
}
