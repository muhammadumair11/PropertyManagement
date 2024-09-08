package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.exceptions.EntityAlreadyExistsException;
import com.umair.PropertyManagement.mapper.ImageMapper;
import com.umair.PropertyManagement.model.Image;
import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.dto.ImagesDTO;
import com.umair.PropertyManagement.repository.ImageRepository;
import com.umair.PropertyManagement.services.ImageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ImageServiceImplementation implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    private static final String UPLOAD_DIR = "/uploads/";

    static {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    @Override
    public List<ImagesDTO> findAllImages() {
        return imageRepository.findAll().stream().map(ImageMapper::ImageToImagesDTO).collect(Collectors.toList());
    }

    @Override
    public Image findImageById(Long imageId) {
        return imageRepository.findById(imageId).orElse(null);
    }

    @Override
    public ImagesDTO createImage(MultipartFile image, Property property) {

        if (image.isEmpty()) {
            throw new EntityAlreadyExistsException("File not available");
        }

        String filePath = UPLOAD_DIR.concat(Objects.requireNonNull(image.getOriginalFilename()));

        File destinationFile = new File(System.getProperty("user.dir") + filePath);
        try {
            image.transferTo(destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Image savedImage = imageRepository.save(
                Image
                        .builder()
                        .url(filePath)
                        .property(property)
                        .build()
        );

        return ImageMapper.ImageToImagesDTO(savedImage);
    }

    @Override
    public Image updateImage(Image image) {
        Image image1 = findImageById(image.getId());
        if (image1 != null) {
            image.setId(image1.getId());
            return imageRepository.save(image);
        }

        return null;
    }

    @Override
    public Boolean deleteImage(Long imageId) {
        Image image = findImageById(imageId);

        if (image != null) {
            String filePath = System.getProperty("user.dir") + image.getUrl();

            // Create a File object
            File file = new File(filePath);

            // Delete the file
            if (file.exists() && file.delete()) {
                imageRepository.deleteById(imageId);

                return findImageById(imageId) == null;
            } else {
                throw new EntityNotFoundException("Failed to delete file: " + filePath);
            }
        } else {
            throw new EntityAlreadyExistsException("Image not found");
        }
    }


}
