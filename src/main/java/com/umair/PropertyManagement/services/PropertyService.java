package com.umair.PropertyManagement.services;


import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.model.dto.ImagesDTO;
import com.umair.PropertyManagement.model.dto.PropertyDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PropertyService {
    List<PropertyDTO> findAllProperties();

    PropertyDTO findPropertyById(Long propertyId);

    PropertyDTO createProperty(PropertyDTO propertyDTO);

    PropertyDTO updateProperty(PropertyDTO propertyDTO);

    Boolean deleteProperty(Long propertyId);

    //    Image save
    List<ImagesDTO> uploadPropertyImages(MultipartFile image, Long propertyId);

    Boolean deletePropertyImages(Long propertyId, Long imageId);
}
