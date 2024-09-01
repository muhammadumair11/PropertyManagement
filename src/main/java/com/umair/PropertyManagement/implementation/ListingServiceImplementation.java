package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.model.Listing;
import com.umair.PropertyManagement.repository.ListingRepository;
import com.umair.PropertyManagement.services.ListingService;
import com.umair.PropertyManagement.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingServiceImplementation implements ListingService {

    @Autowired
    ListingRepository listingRepository;

    @Override
    public List<Listing> findAllListings() {
        return listingRepository.findAll();
    }

    @Override
    public Listing findListingById(Long listingId) {
        return listingRepository.findById(listingId).orElse(null);
    }

    @Override
    public Listing createListing(Listing listing) {
        return listingRepository.save(listing);
    }

    @Override
    public Listing updateListing(Listing listing) {
        Listing listing1 = findListingById(listing.getId());

        if(listing1 != null) {
            listing.setId(listing1.getId());
            return listingRepository.save(listing);
        }
        return null;
    }

    @Override
    public Boolean deleteListing(Long listingId) {
        listingRepository.deleteById(listingId);

        if(findListingById(listingId) == null)
            return true;
        return false;
    }
}
