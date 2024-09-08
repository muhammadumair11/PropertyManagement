package com.umair.PropertyManagement.controller;

import com.umair.PropertyManagement.dto.PropertyTypeDTO;
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
    @GetMapping("{propertyTypeId}")
    public ResponseEntity<PropertyTypeDTO> findById(@PathVariable Long propertyTypeId) {
        return ResponseEntity.ok(propertyTypeService.findPropertyTypeById(propertyTypeId));
    }
    @PostMapping("")
    public ResponseEntity<PropertyTypeDTO> create(@RequestBody PropertyTypeDTO propertyTypeDTO) {
        return ResponseEntity.ok(propertyTypeService.createPropertyType(propertyTypeDTO));
    }
    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody PropertyTypeDTO propertyTypeDTO) {
;       return ResponseEntity.ok(propertyTypeService.updatePropertyType(propertyTypeDTO));
    }
    @DeleteMapping("{propertyTypeId}")
    public ResponseEntity<?> delete(@PathVariable Long propertyTypeId) {
        boolean isDeleted = propertyTypeService.deletePropertyType(propertyTypeId);

        if (isDeleted)
            return ResponseEntity.ok(" Deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Problem in Deleting The New Property Type");
    }
}
