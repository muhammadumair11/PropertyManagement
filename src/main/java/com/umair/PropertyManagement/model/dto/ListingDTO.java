package com.umair.PropertyManagement.model.dto;

import com.umair.PropertyManagement.model.ListingStatus;
import com.umair.PropertyManagement.model.Property;
import jakarta.persistence.*;
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