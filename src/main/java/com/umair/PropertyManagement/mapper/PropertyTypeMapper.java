package com.umair.PropertyManagement.mapper;


import com.umair.PropertyManagement.Enums.PropertyTypeEnum;
import com.umair.PropertyManagement.model.PropertyType;
import com.umair.PropertyManagement.model.dto.PropertyTypeDTO;

public class PropertyTypeMapper {
    public static PropertyTypeDTO PropertyTypeToPropertyTypeDTO(PropertyType propertyType) {
        if (propertyType == null) return null;

        PropertyTypeDTO propertyTypeDTO = new PropertyTypeDTO();
        propertyTypeDTO.setPropertyType(propertyType.getName().name());
        return propertyTypeDTO;
    }

    public static PropertyType PropertyTypeDTOToPropertyType(PropertyTypeDTO propertyTypeDTO) {
        if (propertyTypeDTO == null) return null;

        PropertyType propertyType = new PropertyType();
        propertyType.setName(
                PropertyTypeEnum
                        .valueOf(
                                propertyTypeDTO
                                        .getPropertyType()
                                        .toUpperCase()));

        return propertyType;
    }


}
