package com.umair.PropertyManagement.dto;

import com.umair.PropertyManagement.dto.propertydtos.PropertyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListingDTO {
    private Date listingDate;
    private String listingStatus;
    private PropertyDTO property;
}