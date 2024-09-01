package com.umair.PropertyManagement.services;


import com.umair.PropertyManagement.model.Image;

import java.util.List;

public interface ImageService {
    List<Image> findAllImages();
    Image findImageById(Long imageId);
    Image createImage(Image image);
    Image updateImage(Image image);
    Boolean deleteImage(Long imageId);
}
