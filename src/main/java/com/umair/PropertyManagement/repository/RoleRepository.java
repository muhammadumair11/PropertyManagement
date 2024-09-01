package com.umair.PropertyManagement.repository;

import com.umair.PropertyManagement.Enums.RoleType;
import com.umair.PropertyManagement.model.Role;
import com.umair.PropertyManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleType name);
}
