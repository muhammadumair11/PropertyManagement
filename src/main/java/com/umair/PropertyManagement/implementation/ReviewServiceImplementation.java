package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.model.Review;
import com.umair.PropertyManagement.repository.ReviewRepository;
import com.umair.PropertyManagement.services.ReviewService;
import com.umair.PropertyManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Review review) {
        Review existingReview = findReviewById(review.getId());

        if(existingReview != null) {
            review.setId(existingReview.getId());
            return reviewRepository.save(review);
        }
        return null;
    }

    @Override
    public Boolean deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
        if(findReviewById(reviewId) == null)
            return true;
        return false;
    }
}
