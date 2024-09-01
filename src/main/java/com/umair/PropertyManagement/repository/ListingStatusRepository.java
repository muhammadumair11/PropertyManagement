package com.umair.PropertyManagement.repository;

import com.umair.PropertyManagement.model.ListingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingStatusRepository extends JpaRepository<ListingStatus, Long> {
}
