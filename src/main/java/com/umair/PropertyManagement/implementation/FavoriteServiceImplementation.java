package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.dto.ImagesDTO;
import com.umair.PropertyManagement.exceptions.EntityAlreadyExistsException;
import com.umair.PropertyManagement.mapper.ImageMapper;
import com.umair.PropertyManagement.model.Image;
import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.repository.ImageRepository;
import com.umair.PropertyManagement.repository.PropertyRepository;
import com.umair.PropertyManagement.repository.UserRepository;
import com.umair.PropertyManagement.services.FavoriteService;
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
public class FavoriteServiceImplementation implements FavoriteService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PropertyRepository propertyRepository;

    @Override
    public User addFavorite(Long userId, Long propertyId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        user.getFavoriteProperties().add(property);
        return userRepository.save(user);
    }

    @Override
    public User removeFavorite(Long userId, Long propertyId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        user.getFavoriteProperties().remove(property);
        return userRepository.save(user);
    }
}
