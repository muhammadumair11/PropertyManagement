package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.dto.ReviewDTO;
import com.umair.PropertyManagement.mapper.ReviewMapper;
import com.umair.PropertyManagement.model.Inquiry;
import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.model.Review;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.repository.PropertyRepository;
import com.umair.PropertyManagement.repository.ReviewRepository;
import com.umair.PropertyManagement.repository.UserRepository;
import com.umair.PropertyManagement.services.ReviewService;
import com.umair.PropertyManagement.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImplementation implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PropertyRepository propertyRepository;

    @Override
    public List<ReviewDTO> findAllReviews() {
        List<Review> reviews = reviewRepository.findAll();

        return reviews.stream().map(ReviewMapper::ReviewToReviewDTO).collect(Collectors.toList());
    }

    @Override
    public ReviewDTO findReviewById(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review Not Found"));
        return ReviewMapper.ReviewToReviewDTO(review);
    }

    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        User user = userRepository.findById(reviewDTO.getUserId()).orElseThrow(() -> new RuntimeException("User for Inquiry doesn't exist"));
        Property property = propertyRepository.findById(reviewDTO.getPropertyId()).orElseThrow(() -> new RuntimeException("Property for Inquiry doesn't exist"));


        Review savedReview = reviewRepository.save(
                Review
                        .builder()
                        .comment(reviewDTO.getComment())
                        .rating(reviewDTO.getRating())
                        .user(user)
                        .property(property)
                        .build()
        );

        return  ReviewMapper.ReviewToReviewDTO(savedReview);
    }

    @Override
    public ReviewDTO updateReview(ReviewDTO reviewDTO) {
        Review existingReview = reviewRepository.findById(reviewDTO.getId()).orElseThrow(() -> new RuntimeException("Review doesn't exist"));

        User user = userRepository.findById(reviewDTO.getUserId()).orElseThrow(() -> new RuntimeException("User for Inquiry doesn't exist"));
        Property property = propertyRepository.findById(reviewDTO.getPropertyId()).orElseThrow(() -> new RuntimeException("Property for Inquiry doesn't exist"));

        Review updatedReview = reviewRepository.save(
                existingReview
                        .toBuilder()
                        .id(reviewDTO.getId())
                        .comment(reviewDTO.getComment())
                        .rating(reviewDTO.getRating())
                        .user(user)
                        .property(property)
                        .build()
        );

        return ReviewMapper.ReviewToReviewDTO(updatedReview);
    }

    @Override
    public Boolean deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
        if(reviewRepository.findById(reviewId).orElse(null) == null)
            return true;
        return false;
    }
}
