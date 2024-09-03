package com.umair.PropertyManagement.model.dto;

import com.umair.PropertyManagement.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String agent;
    private String propertyType;
    private AddressDTO address;
    private List<InquiryDTO> inquiries;
    private ContractDTO contract;
    private ListingDTO listing;
    private List<ImagesDTO> images;
    private List<ReviewDTO> reviews;
}
