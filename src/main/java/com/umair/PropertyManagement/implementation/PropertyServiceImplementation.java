package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.mapper.PropertyMapper;
import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.model.dto.PropertyDTO;
import com.umair.PropertyManagement.repository.PropertyRepository;
import com.umair.PropertyManagement.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImplementation implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Override
    public List<PropertyDTO> findAllProperties() {
        return propertyRepository.findAll().stream().map(PropertyMapper::PropertyToPropertyDTO).collect(Collectors.toList());
    }

    @Override
    public Property findPropertyById(Long propertyId) {
        return propertyRepository.findById(propertyId).orElse(null);
    }

    @Override
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property updateProperty(Property property) {
        Property property1 = findPropertyById(property.getId());
        if(property1 != null) {
            property.setId(property1.getId());
            return propertyRepository.save(property);
        }
        return null;
    }

    @Override
    public Boolean deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);

        if(findPropertyById(propertyId) == null)
            return true;
        return false;
    }
}
