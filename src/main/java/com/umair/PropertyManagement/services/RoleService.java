package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.Enums.RoleTypeEnum;
import com.umair.PropertyManagement.model.Role;
import com.umair.PropertyManagement.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> findAllRoles();
    RoleDTO findRoleById(Long roleId);
    Role findRoleByName(String rolename);
    RoleDTO createRole(RoleDTO roleDTO);
    RoleDTO updateRole(RoleDTO roleDTO);
    Boolean deleteRole(Long roleId);
}
