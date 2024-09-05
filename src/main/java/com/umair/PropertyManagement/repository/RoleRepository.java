package com.umair.PropertyManagement.repository;

import com.umair.PropertyManagement.Enums.RoleTypeEnum;
import com.umair.PropertyManagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleTypeEnum name);
}
