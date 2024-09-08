package com.umair.PropertyManagement.controller;

import com.umair.PropertyManagement.dto.ReviewDTO;
import com.umair.PropertyManagement.services.ListingStatusService;
import com.umair.PropertyManagement.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("")
    public ResponseEntity<List<ReviewDTO>> findAll() {
        return ResponseEntity.ok(reviewService.findAllReviews());
    }
    @GetMapping("{reviewId}")
    public ResponseEntity<ReviewDTO> findById(@PathVariable Long reviewId) {
        return ResponseEntity.ok(reviewService.findReviewById(reviewId));
    }
    @PostMapping("")
    public ResponseEntity<ReviewDTO> create(@RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(reviewService.createReview(reviewDTO));
    }
    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody ReviewDTO reviewDTO) {
        ;       return ResponseEntity.ok(reviewService.updateReview(reviewDTO));
    }
    @DeleteMapping("{reviewId}")
    public ResponseEntity<?> delete(@PathVariable Long reviewId) {
        boolean isDeleted = reviewService.deleteReview(reviewId);

        if (isDeleted)
            return ResponseEntity.ok(" Deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Problem in Deleting Review");
    }
}
