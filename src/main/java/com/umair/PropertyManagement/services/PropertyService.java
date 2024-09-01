package com.umair.PropertyManagement.services;


import com.umair.PropertyManagement.model.Property;

import java.util.List;

public interface PropertyService {
    List<Property> findAllProperties();
    Property findPropertyById(Long propertyId);
    Property createProperty(Property property);
    Property updateProperty(Property property);
    Boolean deleteProperty(Long propertyId);
}
