package com.umair.PropertyManagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RoleDTO {
    private Long id;
    private String role;

    public RoleDTO(String role) {
        this.role = role;
    }
}
