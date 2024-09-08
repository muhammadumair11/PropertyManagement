package com.umair.PropertyManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyTypeDTO {
    private Long id;
    private String propertyType;

    public PropertyTypeDTO(String name) {
        this.propertyType = name;
    }
}
