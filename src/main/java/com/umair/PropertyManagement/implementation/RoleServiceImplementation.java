    package com.umair.PropertyManagement.implementation;

    import com.umair.PropertyManagement.Enums.RoleTypeEnum;
    import com.umair.PropertyManagement.mapper.RoleMapper;
    import com.umair.PropertyManagement.model.PropertyType;
    import com.umair.PropertyManagement.model.Role;
    import com.umair.PropertyManagement.model.User;
    import com.umair.PropertyManagement.dto.RoleDTO;
    import com.umair.PropertyManagement.repository.RoleRepository;
    import com.umair.PropertyManagement.repository.UserRepository;
    import com.umair.PropertyManagement.services.RoleService;
    import jakarta.persistence.EntityNotFoundException;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Set;
    import java.util.stream.Collectors;

    @Service
    public class RoleServiceImplementation implements RoleService {

        @Autowired
        RoleRepository roleRepository;

        @Override
        public List<RoleDTO> findAllRoles() {
            return roleRepository.findAll().stream().map(role -> RoleMapper.RoleToRoleDTO(Set.of(role))).collect(Collectors.toList());
        }

        @Override
        public RoleDTO findRoleById(Long roleId) {
            Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role does not exist"));
            return RoleMapper.RoleToRoleDTO(Set.of(role));
        }

        @Override
        public Role findRoleByName(String rolename) {
            return roleRepository.findByName(rolename).orElseThrow(() -> new RuntimeException("Role does not exists"));
        }

        @Override
        public RoleDTO createRole(RoleDTO roleDTO) {
            Role savedRole = roleRepository.save(
                    Role
                            .builder()
                            .name(roleDTO.getRole().toUpperCase())
                            .build()
            );
            return RoleMapper.RoleToRoleDTO(Set.of(savedRole));
        }

        @Override
        public RoleDTO updateRole(RoleDTO roleDTO) {
            Role existingRole = roleRepository.findById(roleDTO.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Role doesn't exists"));

            if (existingRole != null) {
                Role savedRole = roleRepository.save(
                        existingRole
                                .toBuilder()
                                .name(roleDTO.getRole().toUpperCase())
                                .build()
                );

                return RoleMapper.RoleToRoleDTO(Set.of(savedRole));
            }


            return null;
        }

        @Override
        public Boolean deleteRole(Long roleId) {
            roleRepository.deleteById(roleId);
            if (findRoleById(roleId) == null)
                return true;
            return false;
        }
    }
