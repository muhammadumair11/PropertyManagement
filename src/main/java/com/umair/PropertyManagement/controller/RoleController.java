package com.umair.PropertyManagement.controller;

import com.umair.PropertyManagement.dto.ImagesDTO;
import com.umair.PropertyManagement.dto.RoleDTO;
import com.umair.PropertyManagement.dto.propertydtos.PropertyRequestDTO;
import com.umair.PropertyManagement.services.PropertyService;
import com.umair.PropertyManagement.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("{roleId}")
    public ResponseEntity<RoleDTO> findById(@PathVariable Long roleId) {
        return ResponseEntity.ok(roleService.findRoleById(roleId));
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Validated @RequestBody RoleDTO roleDTO) {
        RoleDTO createdRole = roleService.createRole(roleDTO);
        return ResponseEntity.ok(createdRole);
    }

    @PutMapping("")
    public ResponseEntity<RoleDTO> update(@RequestBody RoleDTO roleDTO) {
        RoleDTO updatedProperty = roleService.updateRole(roleDTO);
        return ResponseEntity.ok(updatedProperty);
    }

    @DeleteMapping("{roleId}")
    public ResponseEntity<?> delete(@PathVariable Long roleId) {
        boolean isDeleted = roleService.deleteRole(roleId);

        if (isDeleted)
            return ResponseEntity.ok(" Deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Problem in Deleting The New ");
    }

}
