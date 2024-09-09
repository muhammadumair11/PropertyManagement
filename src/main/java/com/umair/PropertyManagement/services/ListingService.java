package com.umair.PropertyManagement.services;


import com.umair.PropertyManagement.dto.listingdtos.ListingDTO;
import com.umair.PropertyManagement.dto.listingdtos.ListingRequestDTO;
import com.umair.PropertyManagement.model.Listing;

import java.util.List;

public interface ListingService {
    List<ListingDTO> findAllListings();
    ListingDTO findListingById(Long listingId);
    ListingDTO createListing(ListingRequestDTO listingRequestDTO);
    ListingDTO updateListing(ListingRequestDTO listingRequestDTO);
    Boolean deleteListing(Long listingId);
}

