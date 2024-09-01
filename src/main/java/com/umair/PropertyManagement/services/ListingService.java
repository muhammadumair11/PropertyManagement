package com.umair.PropertyManagement.services;


import com.umair.PropertyManagement.model.Listing;

import java.util.List;

public interface ListingService {
    List<Listing> findAllListings();
    Listing findListingById(Long listingId);
    Listing createListing(Listing listing);
    Listing updateListing(Listing listing);
    Boolean deleteListing(Long listingId);
}

