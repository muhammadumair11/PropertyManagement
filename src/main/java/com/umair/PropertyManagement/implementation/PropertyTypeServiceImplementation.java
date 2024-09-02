package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.mapper.PropertyTypeMapper;
import com.umair.PropertyManagement.model.PropertyType;
import com.umair.PropertyManagement.model.dto.PropertyTypeDTO;
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
    public PropertyType findPropertyTypeById(Long propertyTypeId) {
        return propertyTypeRepository.findById(propertyTypeId).orElse(null);
    }

    @Override
    public PropertyType createPropertyType(PropertyType propertyType) {
        return propertyTypeRepository.save(propertyType);
    }

    @Override
    public PropertyType updatePropertyType(PropertyType propertyType) {
        PropertyType propertyType1 = findPropertyTypeById(propertyType.getId());

        if(propertyType1 != null) {
            propertyType.setId(propertyType1.getId());
            return propertyTypeRepository.save(propertyType);
        }
        return null;
    }

    @Override
    public Boolean deletePropertyType(Long propertyTypeId) {
        propertyTypeRepository.deleteById(propertyTypeId);
        if(findPropertyTypeById(propertyTypeId) == null)
            return true;
        return false;
    }
}
