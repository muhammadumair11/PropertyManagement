package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.model.ListingStatus;

import java.util.List;

public interface ListingStatusService {
    List<ListingStatus> findAllListingStatuses();
    ListingStatus findListingStatusById(Long listingStatusId);
    ListingStatus createListingStatus(ListingStatus listingStatus);
    ListingStatus updateListingStatus(ListingStatus listingStatus);
    Boolean deleteListingStatus(Long listingStatusId);
}
