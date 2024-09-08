package com.umair.PropertyManagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String roles;
}
