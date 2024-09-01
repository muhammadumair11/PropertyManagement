package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.dtos.UserDTO;
import com.umair.PropertyManagement.exceptions.UserAlreadyExistsException;
import com.umair.PropertyManagement.mapper.UserMapper;
import com.umair.PropertyManagement.model.Role;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.repository.RoleRepository;
import com.umair.PropertyManagement.repository.UserRepository;
import com.umair.PropertyManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
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

    @Override
    public UserDTO createUser(UserDTO user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new UserAlreadyExistsException("User Already Exist");
        }

        if(user.getRoles() == null || user.getRoles() == "") {
            user.setRoles("BUYER");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userEntity = UserMapper.UserDTOToUser(user, roleRepository);
        User newUser = userRepository.save(userEntity);


        return UserMapper.UserToUserDTO(newUser);
    }

    @Override
    public UserDTO updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);

        if (existingUser != null) {
            user.setId(existingUser.getId());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User savedUser = userRepository.save(user);
            return UserMapper.UserToUserDTO(savedUser);
        }

        return null;
    }

    @Override
    public Boolean deleteUser(Long userId) {
        User user = findUserEntityById(userId);
        userRepository.delete(user);
        if (findUserById(userId) == null)
            return true;
        return false;
    }
}
