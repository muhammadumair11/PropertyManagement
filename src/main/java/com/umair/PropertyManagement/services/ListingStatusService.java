package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.dto.ListingStatusesDTO;
import com.umair.PropertyManagement.model.ListingStatus;

import java.util.List;

public interface ListingStatusService {
    List<ListingStatusesDTO> findAllListingStatuses();
    ListingStatusesDTO findListingStatusById(Long listingStatusId);
    ListingStatusesDTO createListingStatus(ListingStatusesDTO listingStatusesDTO);
    ListingStatusesDTO updateListingStatus(ListingStatusesDTO ListingStatusesDTO);
    Boolean deleteListingStatus(Long listingStatusId);
}
