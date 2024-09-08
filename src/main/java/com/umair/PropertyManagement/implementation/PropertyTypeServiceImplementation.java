package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.mapper.PropertyTypeMapper;
import com.umair.PropertyManagement.model.PropertyType;
import com.umair.PropertyManagement.dto.PropertyTypeDTO;
import com.umair.PropertyManagement.repository.PropertyTypeRepository;
import com.umair.PropertyManagement.services.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyTypeServiceImplementation implements PropertyTypeService {

    @Autowired
    PropertyTypeRepository propertyTypeRepository;

    @Override
    public List<PropertyTypeDTO> findAllPropertyTypes() {
        List<PropertyType> propertyTypes = propertyTypeRepository.findAll();
        return propertyTypes.stream().map(PropertyTypeMapper::PropertyTypeToPropertyTypeDTO).collect(Collectors.toList());
    }

    @Override
    public PropertyTypeDTO findPropertyTypeById(Long propertyTypeId) {
        return PropertyTypeMapper.PropertyTypeToPropertyTypeDTO(propertyTypeRepository.findById(propertyTypeId).orElse(null));
    }

    @Override
    public PropertyTypeDTO findByName(String propertyType) {
        return PropertyTypeMapper.PropertyTypeToPropertyTypeDTO(propertyTypeRepository.findByName(propertyType));
    }

    @Override
    public PropertyTypeDTO createPropertyType(PropertyTypeDTO propertyTypeDTO) {
        PropertyType savedPropertyType = propertyTypeRepository.save(
                PropertyType
                        .builder()
                        .name(propertyTypeDTO.getPropertyType().toUpperCase())
                        .build()
        );

        return PropertyTypeMapper.PropertyTypeToPropertyTypeDTO(savedPropertyType);
    }

    @Override
    public PropertyTypeDTO updatePropertyType(PropertyTypeDTO propertyTypeDTO) {
        PropertyType propertyType1 = propertyTypeRepository
                .findById(
                        propertyTypeDTO
                                .getId()
                )
                .orElseThrow(() -> new RuntimeException("Property Type doesn't exist"));

        if (propertyType1 != null) {
            propertyType1.setId(propertyTypeDTO.getId());
            PropertyType propertyTypeEntity = propertyTypeRepository.save(
                    propertyType1
                            .toBuilder()
                            .id(propertyTypeDTO.getId())
                            .name(propertyTypeDTO.getPropertyType().toUpperCase())
                            .build()
            );
            return PropertyTypeMapper.PropertyTypeToPropertyTypeDTO(propertyTypeEntity);
        }
        return null;
    }

    @Override
    public Boolean deletePropertyType(Long propertyTypeId) {
        propertyTypeRepository.deleteById(propertyTypeId);
        if (findPropertyTypeById(propertyTypeId) == null)
            return true;
        return false;
    }
}
