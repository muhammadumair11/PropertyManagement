package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.Enums.RoleTypeEnum;
import com.umair.PropertyManagement.model.Role;
import com.umair.PropertyManagement.model.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> findAllRoles();
    Role findRoleById(Long roleId);
    Role findRoleByName(RoleTypeEnum name);
    RoleDTO createRole(String rolename, Long userId);
    Role updateRole(Role role);
    Boolean deleteRole(Long roleId);
}
