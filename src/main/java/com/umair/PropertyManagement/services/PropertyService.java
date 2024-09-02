package com.umair.PropertyManagement.services;


import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.model.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    List<PropertyDTO> findAllProperties();
    Property findPropertyById(Long propertyId);
    Property createProperty(Property property);
    Property updateProperty(Property property);
    Boolean deleteProperty(Long propertyId);
}
