package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.dtos.UserDTO;
import com.umair.PropertyManagement.mapper.UserMapper;
import com.umair.PropertyManagement.model.Role;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.repository.RoleRepository;
import com.umair.PropertyManagement.repository.UserRepository;
import com.umair.PropertyManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public UserDTO findUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return UserMapper.UserToUserDTO(user);
    }

    @Override
    public UserDTO createUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser != null) {
            throw new RuntimeException("User Already Exist");
        }

        Role defaultRole = roleRepository.findByName("USER");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(defaultRole));
        User newUser = userRepository.save(user);

        return UserMapper.UserToUserDTO(newUser);
    }

    @Override
    public UserDTO updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);

        if(existingUser != null) {
            user.setId(existingUser.getId());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User savedUser = userRepository.save(user);
            return UserMapper.UserToUserDTO(savedUser);
        }

        return null;
    }

    @Override
    public Boolean deleteUser(Long userId) {
        userRepository.deleteById(userId);
        if(findUserById(userId) == null)
            return true;
        return false;
    }
}
