package com.umair.PropertyManagement.controller;

import com.umair.PropertyManagement.dto.InquiryDTO;
import com.umair.PropertyManagement.dto.listingdtos.ListingDTO;
import com.umair.PropertyManagement.dto.listingdtos.ListingRequestDTO;
import com.umair.PropertyManagement.services.InquiryService;
import com.umair.PropertyManagement.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listings")
public class ListingController {
    @Autowired
    ListingService listingService;

    @GetMapping
    public ResponseEntity<List<ListingDTO>> findAll() {
        return ResponseEntity.ok(listingService.findAllListings());
    }
    @GetMapping("{listingId}")
    public ResponseEntity<ListingDTO> findById(@PathVariable Long listingId) {
        return ResponseEntity.ok(listingService.findListingById(listingId));
    }
    @PostMapping
    public ResponseEntity<ListingDTO> create(@RequestBody ListingRequestDTO listingRequestDTO) {
        return ResponseEntity.ok(listingService.createListing(listingRequestDTO));
    }
    @PutMapping
    public ResponseEntity<ListingDTO> update(@RequestBody ListingRequestDTO listingRequestDTO) {
        return ResponseEntity.ok(listingService.updateListing(listingRequestDTO));
    }
    @DeleteMapping("{listingId}")
    public ResponseEntity<?> delete(@PathVariable Long listingId) {
        boolean isDeleted = listingService.deleteListing(listingId);

        if(isDeleted)
            return ResponseEntity.ok(" Deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Problem in Deleting Inquiry");
    }
}
