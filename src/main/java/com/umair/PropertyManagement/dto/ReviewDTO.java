package com.umair.PropertyManagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private Long id;
    private Integer rating;
    private String comment;
    private Long userId;
    private Long propertyId;
}