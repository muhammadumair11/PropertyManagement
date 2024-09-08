package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.Enums.PropertyTypeEnum;
import com.umair.PropertyManagement.exceptions.EntityAlreadyExistsException;
import com.umair.PropertyManagement.mapper.PropertyMapper;
import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.model.PropertyType;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.dto.ImagesDTO;
import com.umair.PropertyManagement.dto.propertydtos.PropertyDTO;
import com.umair.PropertyManagement.dto.propertydtos.PropertyRequestDTO;
import com.umair.PropertyManagement.repository.PropertyRepository;
import com.umair.PropertyManagement.repository.PropertyTypeRepository;
import com.umair.PropertyManagement.services.ImageService;
import com.umair.PropertyManagement.services.PropertyService;
import com.umair.PropertyManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    ImageService imageService;

    @Override
    public List<PropertyDTO> findAllProperties() {
        return propertyRepository.findAll().stream().map(PropertyMapper::PropertyToPropertyDTO).collect(Collectors.toList());
    }

    private Property findPropertyEntityById(Long propertyId) {
        Property property = propertyRepository
                .findById(propertyId).orElseThrow(() -> new EntityAlreadyExistsException("Property does not exist"));
        return property;
    }

    @Override
    public PropertyDTO findPropertyById(Long propertyId) {
        return PropertyMapper.PropertyToPropertyDTO(findPropertyEntityById(propertyId));
    }

    @Override
    public PropertyDTO createProperty(PropertyRequestDTO propertyRequestDTO) {

        Property propertyEntity = PropertyMapper.PropertyDTOToProperty(propertyRequestDTO);


        PropertyType propertyType = propertyTypeRepository.findByName(
                propertyRequestDTO.getPropertyType()
        );

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User agent = userService.findUserByUsername(username);

        Property newProperty = propertyRepository.save(
                propertyEntity
                        .toBuilder()
                        .propertyType(propertyType)
                        .agent(agent)
                        .build()
        );


        return PropertyMapper.PropertyToPropertyDTO(newProperty);
    }

    @Override
    public PropertyDTO updateProperty(PropertyRequestDTO propertyRequestDTO) {
        Property property1 = propertyRepository.findById(propertyRequestDTO.getId()).orElse(null);
        if (property1 != null) {

            Property propertyEntity = PropertyMapper.PropertyDTOToProperty(propertyRequestDTO);
            Property savedProperty = propertyRepository.save(propertyEntity
                    .toBuilder()
                    .id(property1.getId())
                    .propertyType(property1.getPropertyType())
                    .agent(property1.getAgent())
                    .images(property1.getImages())
                    .reviews(property1.getReviews())
                    .build()
            );
            return PropertyMapper.PropertyToPropertyDTO(savedProperty);
        }
        return null;
    }

    @Override
    public Boolean deleteProperty(Long propertyId) {
        Property property = findPropertyEntityById(propertyId);
        propertyRepository.delete(property);
        if (propertyRepository.findById(propertyId).orElse(null) == null) {
            return true;
        }
        return false;
    }

    @Override
    public List<ImagesDTO> uploadPropertyImages(MultipartFile image, Long propertyId) {
        Property property = findPropertyEntityById(propertyId);

        ImagesDTO savedImage = imageService.createImage(image, property);

        return savedImage != null ? imageService.findAllImages() : null;
    }

    @Override
    public Boolean deletePropertyImages(Long propertyId, Long imageId) {
        return imageService.deleteImage(imageId);


    }


}
