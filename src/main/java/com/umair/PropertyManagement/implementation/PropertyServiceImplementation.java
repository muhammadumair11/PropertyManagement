package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.Enums.PropertyTypeEnum;
import com.umair.PropertyManagement.mapper.PropertyMapper;
import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.model.PropertyType;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.model.dto.PropertyDTO;
import com.umair.PropertyManagement.repository.PropertyRepository;
import com.umair.PropertyManagement.repository.PropertyTypeRepository;
import com.umair.PropertyManagement.services.PropertyService;
import com.umair.PropertyManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImplementation implements PropertyService {

    @Autowired
    PropertyTypeRepository propertyTypeRepository;

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    UserService userService;

    @Override
    public List<PropertyDTO> findAllProperties() {
        return propertyRepository.findAll().stream().map(PropertyMapper::PropertyToPropertyDTO).collect(Collectors.toList());
    }

    @Override
    public PropertyDTO findPropertyById(Long propertyId) {
        Property property = propertyRepository.findById(propertyId).orElse(null);
        return PropertyMapper.PropertyToPropertyDTO(property);
    }

    @Override
    public PropertyDTO createProperty(PropertyDTO propertyDTO) {

        Property propertyEntity = PropertyMapper.PropertyDTOToProperty(propertyDTO);
        PropertyType propertyType = propertyTypeRepository.findByName(PropertyTypeEnum.valueOf(
                propertyDTO.getPropertyType()
        ));

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User agent = userService.findUserByUsername(username);

        propertyEntity.setAgent(agent);

        propertyEntity.setPropertyType(propertyType);
        Property newProperty = propertyRepository.save(propertyEntity);


        return PropertyMapper.PropertyToPropertyDTO(newProperty);
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO) {
        Property property1 = propertyRepository.findById(propertyDTO.getId()).orElse(null);
        if (property1 != null) {
            property1.setId(propertyDTO.getId());
            Property savedProperty = propertyRepository.save(property1);
            return PropertyMapper.PropertyToPropertyDTO(savedProperty);
        }
        return null;
    }

    @Override
    public Boolean deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);

        if (findPropertyById(propertyId) == null)
            return true;
        return false;
    }
}
