package com.umair.PropertyManagement.auth;

import com.umair.PropertyManagement.dto.UserDTO;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    UserService userService;
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO user) {
            UserDTO createdUser = userService.createUser(user);
            return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            return ResponseEntity.ok(authService.login(user));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/currentuser")
    public  ResponseEntity<Object> current() {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
            System.out.println("User Logged In");
        return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
