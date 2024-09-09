package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.model.Image;
import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.dto.propertydtos.PropertyDTO;
import com.umair.PropertyManagement.dto.propertydtos.PropertyRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PropertyMapper {
    public static PropertyDTO PropertyToPropertyDTO(Property property) {
        if (property == null) return null;

        PropertyDTO propertyDTO = new PropertyDTO();

        propertyDTO.setId(property.getId());
        propertyDTO.setTitle(property.getTitle());
        propertyDTO.setDescription(property.getDescription());
        propertyDTO.setPrice(property.getPrice());
        propertyDTO.setAgent(property.getAgent().getUsername());

        // Assuming PropertyType has a string field representing its name or type
        if (property.getPropertyType() != null) {
            propertyDTO.setPropertyType(PropertyTypeMapper.PropertyTypeToPropertyTypeDTO(property.getPropertyType()).getPropertyType());
        }

        // Assuming there are existing mappers for Address, Inquiry, Contract, Listing, Images, and Review
        if (property.getAddress() != null) {
            propertyDTO.setAddress(AddressMapper.AddressToAddressDTO(property.getAddress()));
        }

        if (property.getInquiries() != null) {
            propertyDTO.setInquiries(property.getInquiries().stream().map(InquiryMapper::InquiryToInquiryDTO).collect(Collectors.toList()));
        }

        if (property.getContract() != null) {
            propertyDTO.setContract(ContractMapper.ContractToContractDTO(property.getContract()));
        }


        if (property.getImages() != null) {
            propertyDTO.setImages(property.getImages().stream().map(ImageMapper::ImageToImagesDTO).collect(Collectors.toList()));
        }

        if (property.getReviews() != null) {
            propertyDTO.setReviews(property.getReviews().stream().map(ReviewMapper::ReviewToReviewDTO).collect(Collectors.toList()));
        }

        return propertyDTO;
    }

    public static Property PropertyDTOToProperty(PropertyRequestDTO propertyDTO) {
        if (propertyDTO == null) return null;

        Property property = new Property();
        property.setId(propertyDTO.getId());
        property.setTitle(propertyDTO.getTitle());
        property.setDescription(propertyDTO.getDescription());
        property.setPrice(propertyDTO.getPrice());


        // Set the Address
        property.setAddress(AddressMapper.AddressDTOToAddress(propertyDTO.getAddress()));





        // Set the Images
        if (propertyDTO.getImages() != null) {
            List<Image> images = propertyDTO.getImages().stream().map(ImageMapper::ImagesDTOToImage).toList();
            property.setImages(images);
        }


        return property;

    }


}
