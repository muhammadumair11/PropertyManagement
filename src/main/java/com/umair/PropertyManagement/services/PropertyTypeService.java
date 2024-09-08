package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.model.PropertyType;
import com.umair.PropertyManagement.dto.PropertyTypeDTO;

import java.util.List;

public interface PropertyTypeService {
    List<PropertyTypeDTO> findAllPropertyTypes();
    PropertyTypeDTO findPropertyTypeById(Long propertyTypeId);
    PropertyTypeDTO findByName(String propertyType);
    PropertyTypeDTO createPropertyType(PropertyTypeDTO propertyType);
    PropertyTypeDTO updatePropertyType(PropertyTypeDTO propertyType);
    Boolean deletePropertyType(Long propertyTypeId);
}
