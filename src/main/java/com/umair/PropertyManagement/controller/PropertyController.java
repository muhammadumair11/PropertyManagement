package com.umair.PropertyManagement.controller;

import com.umair.PropertyManagement.mapper.PropertyMapper;
import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.model.dto.ImagesDTO;
import com.umair.PropertyManagement.model.dto.PropertyDTO;
import com.umair.PropertyManagement.model.dto.UserDTO;
import com.umair.PropertyManagement.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("{propertyId}")
    public ResponseEntity<PropertyDTO> findById(@PathVariable Long propertyId) {
        return ResponseEntity.ok(propertyService.findPropertyById(propertyId));
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody PropertyDTO propertyDTO) {
        PropertyDTO createdProperty = propertyService.createProperty(propertyDTO);
        return ResponseEntity.ok(createdProperty);
    }
    @PutMapping("")
    public ResponseEntity<PropertyDTO> update(@RequestBody(required = false) PropertyDTO propertyDTO) {
        PropertyDTO updatedProperty = propertyService.updateProperty(propertyDTO);
        return ResponseEntity.ok(updatedProperty);
    }
    @DeleteMapping("{deleteId}")
    public ResponseEntity<?> delete(@PathVariable Long deleteId) {
        boolean isDeleted = propertyService.deleteProperty(deleteId);

        if(isDeleted)
            return ResponseEntity.ok(" Deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Problem in Deleting The New ");
    }


    @PostMapping("{propertyId}/images")
    public ResponseEntity<List<ImagesDTO>> createImages(@RequestParam("file") MultipartFile multipartFile, @PathVariable Long propertyId) {
        return ResponseEntity.ok(propertyService.uploadPropertyImages(multipartFile, propertyId));
    }
}
