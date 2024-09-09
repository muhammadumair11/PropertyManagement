package com.umair.PropertyManagement.dto.listingdtos;

import com.umair.PropertyManagement.dto.propertydtos.PropertyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListingRequestDTO {
    private Long id;
    private Date listingDate;
    private String listingStatus;
    private Long propertyId;
}
