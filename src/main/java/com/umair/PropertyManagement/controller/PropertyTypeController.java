package com.umair.PropertyManagement.controller;

import com.umair.PropertyManagement.model.dto.PropertyTypeDTO;
import com.umair.PropertyManagement.services.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property-type")
public class PropertyTypeController {

    @Autowired
    PropertyTypeService propertyTypeService;

    @GetMapping("")
    public ResponseEntity<List<PropertyTypeDTO>> findAll() {
        return ResponseEntity.ok(propertyTypeService.findAllPropertyTypes());
    }
//    @GetMapping("{}")
//    public ResponseEntity<> findById() {
//        return ResponseEntity.ok();
//    }
//    @PostMapping("")
//    public ResponseEntity<?> create() {
//
//        if( != null)
//            return ResponseEntity.ok("New  Created");
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("New  is Not Created");
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
