package com.umair.PropertyManagement.controller;

import com.umair.PropertyManagement.dto.InquiryDTO;
import com.umair.PropertyManagement.services.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
public class InquiryController {

    @Autowired
    InquiryService inquiryService;

    @GetMapping("")
    public ResponseEntity<List<InquiryDTO>> findAll() {
        return ResponseEntity.ok(inquiryService.findAllInquiries());
    }
    @GetMapping("{inquiryId}")
    public ResponseEntity<InquiryDTO> findById(@PathVariable Long inquiryId) {
        return ResponseEntity.ok(inquiryService.findInquiryById(inquiryId));
    }
    @PostMapping
    public ResponseEntity<InquiryDTO> create(@RequestBody InquiryDTO inquiryDTO) {
        return ResponseEntity.ok(inquiryService.createInquiry(inquiryDTO));
    }
    @PutMapping
    public ResponseEntity<InquiryDTO> update(@RequestBody InquiryDTO inquiryDTO) {
        return ResponseEntity.ok(inquiryService.updateInquiry(inquiryDTO));
    }
    @DeleteMapping("{inquiryId}")
    public ResponseEntity<?> delete(@PathVariable Long inquiryId) {
        boolean isDeleted = inquiryService.deleteInquiry(inquiryId);

        if(isDeleted)
            return ResponseEntity.ok(" Deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Problem in Deleting Inquiry");
    }
}
