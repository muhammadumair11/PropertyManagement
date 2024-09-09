package com.umair.PropertyManagement.repository;

import com.umair.PropertyManagement.model.Listing;
import com.umair.PropertyManagement.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    Property findByTitleAndDescription(String title, String description);

}
