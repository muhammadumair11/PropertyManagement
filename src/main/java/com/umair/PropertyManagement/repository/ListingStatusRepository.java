package com.umair.PropertyManagement.repository;

import com.umair.PropertyManagement.Enums.ListingStatusesEnum;
import com.umair.PropertyManagement.Enums.PropertyTypeEnum;
import com.umair.PropertyManagement.model.ListingStatus;
import com.umair.PropertyManagement.model.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListingStatusRepository extends JpaRepository<ListingStatus, Long> {
    Optional<ListingStatus> findByName(String listingStatus);
}
