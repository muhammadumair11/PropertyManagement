package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.model.Image;
import com.umair.PropertyManagement.model.dto.ImagesDTO;

public class ImageMapper {

    public static ImagesDTO ImageToImagesDTO(Image image) {
        if (image == null) return null;

        ImagesDTO imagesDTO = new ImagesDTO();
        imagesDTO.setId(image.getId());
        imagesDTO.setUrl(image.getUrl());

        return imagesDTO;
    }

    public static Image ImagesDTOToImage(ImagesDTO imagesDTO) {
        if (imagesDTO == null) return null;

        Image image = new Image();
        image.setUrl(imagesDTO.getUrl());

        return image;
    }
}
