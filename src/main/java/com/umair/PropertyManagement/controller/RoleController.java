package com.umair.PropertyManagement.controller;

import com.umair.PropertyManagement.model.dto.RoleDTO;
import com.umair.PropertyManagement.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("")
    public ResponseEntity<List<RoleDTO>> findAll() {
        return ResponseEntity.ok(roleService.findAllRoles());
    }
//    @GetMapping("{}")
//    public ResponseEntity<> findById() {
//        return ResponseEntity.ok();
//    }
//    @PostMapping("{userId}")
//    public ResponseEntity<?> create(@PathVariable Long userId ,@RequestParam String rolename) {
////        return ResponseEntity.ok(roleService.createRole(rolename, userId));
//    }
//    @PutMapping("")
//    public ResponseEntity<?> update() {
//
//        if()
//            return ResponseEntity.ok(" Updated");
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Problem in Updating The New ");
//    }
//    @DeleteMapping("{}")
//    public ResponseEntity<?> delete() {
//        boolean isDeleted =
//
//        if(isDeleted)
//            return ResponseEntity.ok(" Deleted");
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Problem in Deleting The New ");
//    }
}
