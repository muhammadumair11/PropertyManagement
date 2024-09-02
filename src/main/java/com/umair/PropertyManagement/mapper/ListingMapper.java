package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.model.Listing;
import com.umair.PropertyManagement.model.dto.ListingDTO;
import com.umair.PropertyManagement.model.dto.ListingStatusesDTO;

import java.util.Date;

public class ListingMapper {

    public static ListingDTO ListingToListingDTO(Listing listing) {
        if (listing == null) return null;

        ListingDTO listingDTO = new ListingDTO();
        listingDTO.setListingDate(listing.getListingDate());

        // Convert ListingStatus to its string representation if needed
        if (listing.getListingStatus() != null) {
            listingDTO.setListingStatus(listing.getListingStatus().getName().name()); // Adjust if necessary
        }

        // Convert Property to PropertyDTO
        if (listing.getProperty() != null) {
            listingDTO.setProperty(PropertyMapper.PropertyToPropertyDTO(listing.getProperty()));
        }

        return listingDTO;
    }

    public static Listing ListingDTOToListing(ListingDTO listingDTO) {
        if (listingDTO == null) return null;

        Listing listing = new Listing();
        listing.setListingDate(listingDTO.getListingDate());

        // Set ListingStatus if it’s provided as a string or needs conversion
        if (listingDTO.getListingStatus() != null) {
            listing.setListingStatus(ListingStatusMapper.ListingStatusesDTOToListingStatus(new ListingStatusesDTO(listingDTO.getListingStatus())));
        }

        return listing;
    }
}
