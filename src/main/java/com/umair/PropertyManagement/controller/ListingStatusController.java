package com.umair.PropertyManagement.controller;

import com.umair.PropertyManagement.dto.ListingStatusesDTO;
import com.umair.PropertyManagement.dto.PropertyTypeDTO;
import com.umair.PropertyManagement.services.ListingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listing-statuses")
public class ListingStatusController {

    @Autowired
    ListingStatusService listingStatusService;

    @GetMapping("")
    public ResponseEntity<List<ListingStatusesDTO>> findAll() {
        return ResponseEntity.ok(listingStatusService.findAllListingStatuses());
    }
    @GetMapping("{listingStatusId}")
    public ResponseEntity<ListingStatusesDTO> findById(@PathVariable Long listingStatusId) {
        return ResponseEntity.ok(listingStatusService.findListingStatusById(listingStatusId));
    }
    @PostMapping("")
    public ResponseEntity<ListingStatusesDTO> create(@RequestBody ListingStatusesDTO propertyTypeDTO) {
        return ResponseEntity.ok(listingStatusService.createListingStatus(propertyTypeDTO));
    }
    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody ListingStatusesDTO propertyTypeDTO) {
        ;       return ResponseEntity.ok(listingStatusService.updateListingStatus(propertyTypeDTO));
    }
    @DeleteMapping("{listingStatusId}")
    public ResponseEntity<?> delete(@PathVariable Long listingStatusId) {
        boolean isDeleted = listingStatusService.deleteListingStatus(listingStatusId);

        if (isDeleted)
            return ResponseEntity.ok(" Deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Problem in Deleting Listing Status");
    }
}
