package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.model.PropertyType;
import com.umair.PropertyManagement.model.dto.PropertyTypeDTO;

import java.util.List;

public interface PropertyTypeService {
    List<PropertyTypeDTO> findAllPropertyTypes();
    PropertyType findPropertyTypeById(Long propertyTypeId);
    PropertyType createPropertyType(PropertyType propertyType);
    PropertyType updatePropertyType(PropertyType propertyType);
    Boolean deletePropertyType(Long propertyTypeId);
}
