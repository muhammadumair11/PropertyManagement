package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.model.dto.UserDTO;
import com.umair.PropertyManagement.exceptions.EntityAlreadyExistsException;
import com.umair.PropertyManagement.mapper.UserMapper;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.repository.RoleRepository;
import com.umair.PropertyManagement.repository.UserRepository;
import com.umair.PropertyManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(UserMapper::UserToUserDTO).collect(Collectors.toList());
    }

    private User findUserEntityById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User does not exist");
        }
        return user;
    }

    @Override
    public UserDTO findUserById(Long userId) {
        return UserMapper.UserToUserDTO(findUserEntityById(userId));
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new EntityAlreadyExistsException("User Already Exist");
        }

        if (user.getRoles() == null || user.getRoles() == "") {
            user.setRoles("BUYER");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userEntity = UserMapper.UserDTOToUser(user, roleRepository);
        User newUser = userRepository.save(userEntity);


        return UserMapper.UserToUserDTO(newUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        UserDTO existingUser = findUserById(userDTO.getId());


        if (existingUser != null) {
            userDTO.setId(existingUser.getId());
            userDTO.setUsername(existingUser.getUsername());
            userDTO.setEmail(existingUser.getEmail());
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            if (userDTO.getRoles().isEmpty()) {
                throw new EntityAlreadyExistsException("Role does not exists");
            }

            User savedUser = userRepository.save(UserMapper.UserDTOToUser(userDTO, roleRepository));
            return UserMapper.UserToUserDTO(savedUser);
        }

        return null;
    }

    @Override
    public Boolean deleteUser(Long userId) {
        User user = findUserEntityById(userId);
        userRepository.delete(user);
        if (userRepository.findById(userId).orElse(null) == null)
            return true;
        return false;
    }


    /*
        The following Functions deals with, User and Roles,
        Adding new role for a specific user
        and Also removing a specific Role from user
     */
    public UserDTO addRoleForUser(Long userId, String rolename) {
        UserDTO userDTO = findUserById(userId);
        if (userDTO.getRoles().contains(rolename))
            throw new EntityAlreadyExistsException("Role already exists");

        userDTO.setRoles(userDTO.getRoles().concat(",").concat(rolename));
        User user = UserMapper.UserDTOToUser(userDTO, roleRepository);
        User savedUser = userRepository.save(user);


        return UserMapper.UserToUserDTO(savedUser);
    }

    public UserDTO deleteRoleFromUser(Long userId, String rolename) {
        UserDTO userDTO = findUserById(userId);

        if (!userDTO.getRoles().contains(rolename))
            throw new EntityAlreadyExistsException("Role does not exists");
        if (userDTO.getRoles().isEmpty() || userDTO.getRoles().equals(rolename))
            throw new IllegalArgumentException("Role cannot be empty");

        userDTO
                .setRoles(userDTO
                        .getRoles()
                        .replaceFirst(",", "")
                        .replaceFirst(rolename, "")
                );

        User user = UserMapper.UserDTOToUser(userDTO, roleRepository);
        userRepository.save(user);

        return findUserById(userId);

    }
}
