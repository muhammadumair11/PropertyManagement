package com.umair.PropertyManagement.services;


import com.umair.PropertyManagement.model.Image;
import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.model.dto.ImagesDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    List<ImagesDTO> findAllImages();
    Image findImageById(Long imageId);
    ImagesDTO createImage(MultipartFile image, Property property);
    Image updateImage(Image image);
    Boolean deleteImage(Long imageId);
}
