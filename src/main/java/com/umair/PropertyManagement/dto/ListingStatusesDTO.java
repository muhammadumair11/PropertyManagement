package com.umair.PropertyManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListingStatusesDTO {
    private Long id;
    private String name;

    public ListingStatusesDTO(String name) {
        this.name = name;
    }
}
