package com.example.uberreviewservice.services.interfaces;

import com.example.uberreviewservice.models.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReviewService {

    Optional<Review> findReviewById(Long id);

    List<Review> findAllReviews();

    boolean deleteReviewById(Long id);

    Review createReview(Review review);

    Review updateReview(Long id, Review review);

}
