package com.umair.PropertyManagement.dto.propertydtos;

import com.umair.PropertyManagement.dto.AddressDTO;
import com.umair.PropertyManagement.dto.ImagesDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyRequestDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String propertyType;
    private AddressDTO address;
    private List<ImagesDTO> images;
//    private Long id;
//    @NotBlank(message = "Title not found")
//    private String title;
//    @NotBlank(message = "Description not found")
//    private String description;
//    @NotBlank(message = "Price not found")
//    private Double price;
//    @NotBlank(message = "Property Type not found")
//    private String propertyType;
//    @NotBlank(message = "Address not found")
//    private AddressDTO address;
//    @NotBlank(message = "Images not found")
//    private List<ImagesDTO> images;
}
