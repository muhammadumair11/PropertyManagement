package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.dto.ReviewDTO;
import com.umair.PropertyManagement.model.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> findAllReviews();
    ReviewDTO findReviewById(Long reviewId);
    ReviewDTO createReview(ReviewDTO reviewDTO);
    ReviewDTO updateReview(ReviewDTO reviewDTO);
    Boolean deleteReview(Long reviewId);
}
