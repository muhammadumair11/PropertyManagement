package com.umair.PropertyManagement.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RoleDTO {
    private String roles;

    public RoleDTO(String roles) {
        this.roles = roles;
    }
}
