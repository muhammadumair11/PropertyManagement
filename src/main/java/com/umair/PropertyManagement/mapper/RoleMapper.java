package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.Enums.RoleTypeEnum;
import com.umair.PropertyManagement.model.dto.RoleDTO;
import com.umair.PropertyManagement.model.Role;
import com.umair.PropertyManagement.repository.RoleRepository;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RoleMapper {

    public static RoleDTO RoleToRoleDTO(Set<Role> roles) {
        if (roles == null) return null;

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoles(roles.stream().map(role -> role.getName().name()).collect(Collectors.joining(",")));
        return roleDTO;
    }

    public static Set<Role> RoleDTOToRole(RoleDTO roleDTO, RoleRepository roleRepository) {
        if (roleDTO == null) return null;

        Set<Role> roles = Arrays.stream(roleDTO.getRoles().split(","))
                .map(String::trim)
                .map(roleName -> {
                    Role role = roleRepository.findByName(RoleTypeEnum.valueOf(roleName.toUpperCase()));
                    if (role == null) {
                        throw new IllegalArgumentException("Invalid role type: " + roleName);
                    }
                    return role;
                })
                .collect(Collectors.toSet());

        return roles;
    }


}
