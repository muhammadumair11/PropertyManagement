package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.dto.listingdtos.ListingDTO;
import com.umair.PropertyManagement.dto.listingdtos.ListingRequestDTO;
import com.umair.PropertyManagement.mapper.ListingMapper;
import com.umair.PropertyManagement.model.Listing;
import com.umair.PropertyManagement.model.ListingStatus;
import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.repository.ListingRepository;
import com.umair.PropertyManagement.repository.ListingStatusRepository;
import com.umair.PropertyManagement.repository.PropertyRepository;
import com.umair.PropertyManagement.services.ListingService;
import com.umair.PropertyManagement.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListingServiceImplementation implements ListingService {

    @Autowired
    ListingRepository listingRepository;

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    ListingStatusRepository listingStatusRepository;


    @Override
    public List<ListingDTO> findAllListings() {
        List<Listing> listings = listingRepository.findAll();

        return listings.stream().map(ListingMapper::ListingToListingDTO).collect(Collectors.toList());
    }

    @Override
    public ListingDTO findListingById(Long listingId) {
        Listing listing = listingRepository.findById(listingId)
                .orElseThrow(() -> new RuntimeException("Listing not found"));
        return ListingMapper.ListingToListingDTO(listing);
    }

    @Override
    public ListingDTO createListing(ListingRequestDTO listingRequestDTO) {
        Property property = propertyRepository.findById(listingRequestDTO.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found"));

        ListingStatus listingStatus = listingStatusRepository.findByName(listingRequestDTO.getListingStatus())
                .orElseThrow(() -> new RuntimeException("Listing Status not found"));


        Listing savedListing = listingRepository.save(
                Listing
                        .builder()
                        .listingDate(listingRequestDTO.getListingDate())
                        .listingStatus(listingStatus)
                        .property(property)
                        .build()
        );

        return ListingMapper.ListingToListingDTO(savedListing);
    }

    @Override
    public ListingDTO updateListing(ListingRequestDTO listingRequestDTO) {
        Listing existingListing = listingRepository.findById(listingRequestDTO.getId())
                .orElseThrow(() -> new RuntimeException("Listing Not Found"));

        Property property = propertyRepository.findById(listingRequestDTO.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found"));

        ListingStatus listingStatus = listingStatusRepository.findByName(listingRequestDTO.getListingStatus())
                .orElseThrow(() -> new RuntimeException("Listing Status not found"));

        Listing updatedListing = listingRepository.save(
                existingListing
                        .toBuilder()
                        .id(listingRequestDTO.getId())
                        .listingDate(listingRequestDTO.getListingDate())
                        .listingStatus(listingStatus)
                        .property(property)
                        .build()
        );

        return ListingMapper.ListingToListingDTO(updatedListing);
    }


    @Override
    public Boolean deleteListing(Long listingId) {
        listingRepository.deleteById(listingId);
        if (listingRepository.findById(listingId).orElse(null) == null)
            return true;
        return false;
    }
}
