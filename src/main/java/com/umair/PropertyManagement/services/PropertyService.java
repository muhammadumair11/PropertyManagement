package com.umair.PropertyManagement.services;


import com.umair.PropertyManagement.dto.ImagesDTO;
import com.umair.PropertyManagement.dto.propertydtos.PropertyDTO;
import com.umair.PropertyManagement.dto.propertydtos.PropertyRequestDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PropertyService {
    List<PropertyDTO> findAllProperties();

    PropertyDTO findPropertyById(Long propertyId);

    PropertyDTO createProperty(PropertyRequestDTO propertyRequestDTO);

    PropertyDTO updateProperty(PropertyRequestDTO propertyRequestDTO);

    Boolean deleteProperty(Long propertyId);

    //    Image save
    List<ImagesDTO> uploadPropertyImages(MultipartFile image, Long propertyId);

    Boolean deletePropertyImages(Long propertyId, Long imageId);
}
