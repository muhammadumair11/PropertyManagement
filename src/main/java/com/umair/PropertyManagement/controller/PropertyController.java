package com.umair.PropertyManagement.controller;

import com.umair.PropertyManagement.dto.ImagesDTO;
import com.umair.PropertyManagement.dto.propertydtos.PropertyDTO;
import com.umair.PropertyManagement.dto.propertydtos.PropertyRequestDTO;
import com.umair.PropertyManagement.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<?> create(@Validated @RequestBody PropertyRequestDTO propertyDTO) {
        PropertyDTO createdProperty = propertyService.createProperty(propertyDTO);
        return ResponseEntity.ok(createdProperty);
    }

    @PutMapping("")
    public ResponseEntity<PropertyDTO> update(@RequestBody PropertyRequestDTO propertyRequestDTO) {
        PropertyDTO updatedProperty = propertyService.updateProperty(propertyRequestDTO);
        return ResponseEntity.ok(updatedProperty);
    }

    @DeleteMapping("{deleteId}")
    public ResponseEntity<?> delete(@PathVariable Long deleteId) {
        boolean isDeleted = propertyService.deleteProperty(deleteId);

        if (isDeleted)
            return ResponseEntity.ok(" Deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Problem in Deleting The New ");
    }


    @PostMapping("{propertyId}/images")
    public ResponseEntity<List<ImagesDTO>> createImages(@RequestParam("file") MultipartFile multipartFile, @PathVariable Long propertyId) {
        return ResponseEntity.ok(propertyService.uploadPropertyImages(multipartFile, propertyId));
    }

    @DeleteMapping("{propertyId}/images/{imageId}")
    public ResponseEntity<?> createImages(@PathVariable Long propertyId, @PathVariable Long imageId) {
        if (propertyService.deletePropertyImages(propertyId, imageId))
            return ResponseEntity.ok("Image Deleted");
        return ResponseEntity.badRequest().body("Something wrong with deletion");
    }
}
