package com.umair.PropertyManagement.services;


import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.model.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    List<PropertyDTO> findAllProperties();
    PropertyDTO findPropertyById(Long propertyId);
    PropertyDTO createProperty(PropertyDTO propertyDTO);
    PropertyDTO updateProperty(PropertyDTO propertyDTO);
    Boolean deleteProperty(Long propertyId);
}
