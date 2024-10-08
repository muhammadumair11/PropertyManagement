package com.umair.PropertyManagement.controller;

import com.umair.PropertyManagement.dto.UserDTO;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody UserDTO user) {
        UserDTO createdUser = userService.createUser(user);

        if (createdUser != null)
            return ResponseEntity.ok("New User Created");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("New User is Not Created");
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO) {
        UserDTO updateUser = userService.updateUser(userDTO);
        return ResponseEntity.ok(updateUser);

    }

    @DeleteMapping("{userId}")
    public ResponseEntity<?> delete(@PathVariable Long userId) {
        boolean isDeleted = userService.deleteUser(userId);

        if (isDeleted)
            return ResponseEntity.ok("User Deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Problem in Deleting The New User");
    }


    /*
        Role based Controllers
     */
    @PostMapping("{userId}/role")
    public ResponseEntity<UserDTO> addRoleForUser(@PathVariable Long userId, @RequestParam String rolename) {
        return ResponseEntity.ok(userService.addRoleForUser(userId, rolename));
    }

    @DeleteMapping("{userId}/role")
    public ResponseEntity<UserDTO> deleteRoleForUser(@PathVariable Long userId, @RequestParam String rolename) {
        return ResponseEntity.ok(userService.deleteRoleFromUser(userId, rolename));
    }

    /*
        Favorite Properties of User
     */
    @PostMapping("{userId}/favorites/{propertyId}")
    public ResponseEntity<User> addFavorite(@PathVariable Long userId, @PathVariable Long propertyId) {
        return ResponseEntity.ok(userService.addFavoriteProperty(userId, propertyId));
    }

    @DeleteMapping("{userId}/favorites/{propertyId}")
    public ResponseEntity<User> removeFavorite(@PathVariable Long userId, @PathVariable Long propertyId) {
        return ResponseEntity.ok(userService.removeFavoriteProperty(userId, propertyId));
    }
}
