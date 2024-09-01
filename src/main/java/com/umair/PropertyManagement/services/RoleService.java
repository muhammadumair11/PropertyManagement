package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.Enums.RoleType;
import com.umair.PropertyManagement.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRoles();
    Role findRoleById(Long roleId);
    Role findRoleByName(RoleType name);
    Role createRole(Role role);
    Role updateRole(Role role);
    Boolean deleteRole(Long roleId);
}
