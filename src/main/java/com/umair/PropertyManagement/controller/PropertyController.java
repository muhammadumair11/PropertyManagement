package com.umair.PropertyManagement.controller;

import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.model.dto.PropertyDTO;
import com.umair.PropertyManagement.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping("")
    public ResponseEntity<List<PropertyDTO>> findAll() {
        return ResponseEntity.ok(propertyService.findAllProperties());
    }
//    @GetMapping("{}")
//    public ResponseEntity<> findById() {
//        return ResponseEntity.ok();
//    }
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Property property) {
        Property createdProperty = propertyService.createProperty(property);
        if(createdProperty != null)
            return ResponseEntity.ok(createdProperty);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("New  is Not Created");
    }
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
