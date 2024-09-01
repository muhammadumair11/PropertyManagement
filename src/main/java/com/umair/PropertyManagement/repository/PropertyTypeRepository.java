package com.umair.PropertyManagement.repository;

import com.umair.PropertyManagement.model.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {
}
