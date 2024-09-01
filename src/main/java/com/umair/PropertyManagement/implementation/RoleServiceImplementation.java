package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.Enums.RoleType;
import com.umair.PropertyManagement.model.Role;
import com.umair.PropertyManagement.repository.RoleRepository;
import com.umair.PropertyManagement.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImplementation implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleById(Long roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }
    @Override
    public Role findRoleByName(RoleType name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        Role existingRole = findRoleById(role.getId());

        if(existingRole != null) {
            role.setId(existingRole.getId());
            return roleRepository.save(role);
        }

        return null;
    }

    @Override
    public Boolean deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
        if(findRoleById(roleId) == null)
            return true;
        return false;
    }
}
