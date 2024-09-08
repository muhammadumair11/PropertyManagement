package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.model.Review;
import com.umair.PropertyManagement.dto.ReviewDTO;

public class ReviewMapper {

    public static ReviewDTO ReviewToReviewDTO(Review review) {
        if (review == null) return null;

        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setComment(review.getComment());
        reviewDTO.setUserId(review.getUser().getId());
        reviewDTO.setPropertyId(review.getProperty().getId());

        return reviewDTO;
    }

    public static Review ReviewDTOToReview(ReviewDTO reviewDTO) {
        if (reviewDTO == null) return null;

        Review review = new Review();
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());

        return review;
    }
}
