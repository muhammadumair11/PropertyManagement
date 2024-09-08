package com.umair.PropertyManagement.mapper;


import com.umair.PropertyManagement.Enums.PropertyTypeEnum;
import com.umair.PropertyManagement.model.PropertyType;
import com.umair.PropertyManagement.dto.PropertyTypeDTO;

public class PropertyTypeMapper {
    public static PropertyTypeDTO PropertyTypeToPropertyTypeDTO(PropertyType propertyType) {
        if (propertyType == null) return null;

        PropertyTypeDTO propertyTypeDTO = new PropertyTypeDTO();
        propertyTypeDTO.setId(propertyType.getId());
        propertyTypeDTO.setPropertyType(propertyType.getName());
        return propertyTypeDTO;
    }

    public static PropertyType PropertyTypeDTOToPropertyType(PropertyTypeDTO propertyTypeDTO) {
        if (propertyTypeDTO == null) return null;
        if (propertyTypeDTO.getPropertyType() == null) return null;

        PropertyType propertyType = new PropertyType();
        propertyType.setName(propertyTypeDTO.getPropertyType().toUpperCase());

        return propertyType;
    }


}
