package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.repository.PropertyRepository;
import com.umair.PropertyManagement.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImplementation implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Override
    public List<Property> findAllProperties() {
        return propertyRepository.findAll();
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
