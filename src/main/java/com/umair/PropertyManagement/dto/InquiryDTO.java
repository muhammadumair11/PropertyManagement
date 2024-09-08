package com.umair.PropertyManagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class InquiryDTO {
    private Long id;
    private String message;
    private Long userId;
    private Long propertyId;
}