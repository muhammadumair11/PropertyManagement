    package com.umair.PropertyManagement.implementation;

    import com.umair.PropertyManagement.Enums.RoleTypeEnum;
    import com.umair.PropertyManagement.mapper.RoleMapper;
    import com.umair.PropertyManagement.mapper.UserMapper;
    import com.umair.PropertyManagement.model.Role;
    import com.umair.PropertyManagement.model.User;
    import com.umair.PropertyManagement.model.dto.RoleDTO;
    import com.umair.PropertyManagement.repository.RoleRepository;
    import com.umair.PropertyManagement.repository.UserRepository;
    import com.umair.PropertyManagement.services.RoleService;
    import com.umair.PropertyManagement.services.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Set;
    import java.util.stream.Collectors;

    @Service
    public class RoleServiceImplementation implements RoleService {

        @Autowired
        RoleRepository roleRepository;
        @Autowired
        UserRepository userRepository;

        @Override
        public List<RoleDTO> findAllRoles() {
            return roleRepository.findAll().stream().map(role -> RoleMapper.RoleToRoleDTO(Set.of(role))).collect(Collectors.toList());
        }

        @Override
        public Role findRoleById(Long roleId) {
            return roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role does not exist"));
        }

        @Override
        public Role findRoleByName(RoleTypeEnum name) {
            return roleRepository.findByName(name).orElseThrow(() -> new RuntimeException("Role does not exists"));
        }

        @Override
        public RoleDTO createRole(String rolename, Long userId) {
            String roleType = rolename;

            if (roleType == null || roleType.trim().isEmpty()) {
                roleType = RoleTypeEnum.BUYER.name();
            }


            Set<Role> roles = RoleMapper.RoleDTOToRole(new RoleDTO(roleType), roleRepository);

            User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User doesnt' exist"));
    //        System.out.println(roleType);
    //        System.out.println(roleType);
    //        System.out.println( user.getUsername());
            roles.forEach(role -> System.out.println(role.getName()));


            roles.forEach(role -> {
                role.getUsers().add(user);
            });
            Set<Role> savedRoles = roles
                    .stream()
                    .map(roleRepository::save)
                    .collect(Collectors.toSet());




            return RoleMapper.RoleToRoleDTO(savedRoles);
        }

        @Override
        public Role updateRole(Role role) {
            Role existingRole = findRoleById(role.getId());

            if (existingRole != null) {
                role.setId(existingRole.getId());
                return roleRepository.save(role);
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
