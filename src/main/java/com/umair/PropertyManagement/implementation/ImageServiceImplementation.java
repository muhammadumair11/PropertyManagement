package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.model.Image;
import com.umair.PropertyManagement.repository.ImageRepository;
import com.umair.PropertyManagement.services.ImageService;
import com.umair.PropertyManagement.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImplementation implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public List<Image> findAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Image findImageById(Long imageId) {
        return imageRepository.findById(imageId).orElse(null);
    }

    @Override
    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image updateImage(Image image) {
        Image image1 = findImageById(image.getId());
        if(image1 != null) {
            image.setId(image1.getId());
            return imageRepository.save(image);
        }

        return null;
    }

    @Override
    public Boolean deleteImage(Long imageId) {
        imageRepository.deleteById(imageId);
        if (findImageById(imageId) == null)
            return true;
        return false;
    }
}
