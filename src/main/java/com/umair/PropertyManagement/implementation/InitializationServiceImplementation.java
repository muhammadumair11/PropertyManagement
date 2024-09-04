package com.umair.PropertyManagement.implementation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umair.PropertyManagement.Enums.ListingStatusesEnum;
import com.umair.PropertyManagement.Enums.PropertyTypeEnum;
import com.umair.PropertyManagement.Enums.RoleTypeEnum;
import com.umair.PropertyManagement.auth.AuthService;
import com.umair.PropertyManagement.mapper.PropertyMapper;
import com.umair.PropertyManagement.model.ListingStatus;
import com.umair.PropertyManagement.model.PropertyType;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.model.dto.PropertyDTO;
import com.umair.PropertyManagement.model.dto.UserDTO;
import com.umair.PropertyManagement.exceptions.EntityAlreadyExistsException;
import com.umair.PropertyManagement.model.Role;
import com.umair.PropertyManagement.repository.ListingStatusRepository;
import com.umair.PropertyManagement.repository.PropertyRepository;
import com.umair.PropertyManagement.repository.PropertyTypeRepository;
import com.umair.PropertyManagement.repository.RoleRepository;
import com.umair.PropertyManagement.services.InitializationService;
import com.umair.PropertyManagement.services.PropertyService;
import com.umair.PropertyManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class InitializationServiceImplementation implements InitializationService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PropertyTypeRepository propertyTypeRepository;
    @Autowired
    ListingStatusRepository listingStatusRepository;

    @Autowired
    UserService userService;
    @Autowired
    PropertyRepository propertyRepository;
    @Autowired
    PropertyService propertyService;

    @Autowired
    AuthenticationManager authenticationManager;

    public void initialize() {
        try {
            // First data is inserted from Dummy json or Enum files
            insertAllRoleTypes();
            insertAllPropertyTypes();
            insertAllListingStatuses();

            //Second Users are loaded into database from dummy json provided in resources
            loadUsers();

            //Third a user is logged in for the authentication details needed for other services
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                Authentication auth = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken("user", "123")
                );
                SecurityContextHolder.getContext().setAuthentication(auth);

            }


            // In the end properties are inserted from json with currently logged in user as agent
            loadProperties();

            System.out.println("Ready Now");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void insertAllRoleTypes() {

        RoleTypeEnum[] roleTypes = RoleTypeEnum.values();

        for (RoleTypeEnum roleType : roleTypes) {
            if (roleRepository.findByName(roleType) == null) {
                roleRepository.save(new Role(roleType));
            }
        }
    }

    private void insertAllPropertyTypes() {

        PropertyTypeEnum[] propertyTypeEnums = PropertyTypeEnum.values();

        for (PropertyTypeEnum propertyTypeEnum : propertyTypeEnums) {
            if (propertyTypeRepository.findByName(propertyTypeEnum) == null) {
                propertyTypeRepository.save(new PropertyType(propertyTypeEnum));
            }
        }
    }

    private void insertAllListingStatuses() {
        ListingStatusesEnum[] listingStatusesEnums = ListingStatusesEnum.values();

        for (ListingStatusesEnum listingStatusesEnum : listingStatusesEnums) {
            if (listingStatusRepository.findByName(listingStatusesEnum) == null) {
                listingStatusRepository.save(new ListingStatus(listingStatusesEnum));
            }
        }
    }


    private void loadUsers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<UserDTO> users = objectMapper.readValue(
                new ClassPathResource("users.json").getInputStream(),
                new TypeReference<List<UserDTO>>() {
                }
        );
        users.forEach(user -> {
            try {
                userService.createUser(user);
            } catch (EntityAlreadyExistsException e) {
                System.err.println("User already exists: " + user.getUsername());
            }
        });
    }

    private void loadProperties() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<PropertyDTO> propertyDTOS = objectMapper.readValue(
                new ClassPathResource("property.json").getInputStream(),
                new TypeReference<List<PropertyDTO>>() {
                }
        );
        propertyDTOS.forEach(propertyDTO -> {
            try {
                if (propertyRepository.findByTitleAndDescription(propertyDTO.getTitle(), propertyDTO.getDescription()) == null) {
                    propertyService.createProperty(propertyDTO);
                }
            } catch (EntityAlreadyExistsException e) {
                System.err.println("Property already exists: " + propertyDTO.getTitle());
            }
        });
    }

}
