package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews();
    Review findReviewById(Long reviewId);
    Review createReview(Review review);
    Review updateReview(Review review);
    Boolean deleteReview(Long reviewId);
}
