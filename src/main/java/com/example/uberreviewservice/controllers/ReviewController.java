package com.example.uberreviewservice.controllers;

import com.example.uberreviewservice.adapters.ReviewDTOToReviewAdapter;
import com.example.uberreviewservice.dtos.ReviewDTO;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.services.interfaces.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/reviews")
public class ReviewController {

    private final ReviewDTOToReviewAdapter reviewDTOToReviewAdapter;
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody ReviewDTO reviewDTO) {
        Review request = reviewDTOToReviewAdapter.convertReviewDtoToReview(reviewDTO);
        if (request == null ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid argument");
        }

        Review review = reviewService.createReview(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> findReviewById(@PathVariable Long reviewId) {
        try {
            Optional<Review> review = reviewService.findReviewById(reviewId);
            return ResponseEntity.status(HttpStatus.OK).body(review);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<List<Review>> findAllReview() {
        List<Review> reviews = reviewService.findAllReviews();
        return ResponseEntity.status(HttpStatus.OK).body(reviews);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long reviewId) {
        try {
            boolean isDeleted = reviewService.deleteReviewById(reviewId);
            if (!isDeleted) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to delete Review");
            return ResponseEntity.status(HttpStatus.OK).body("Review Deleted Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId, @RequestBody ReviewDTO reviewDTO) {
        Review request = reviewDTOToReviewAdapter.convertReviewDtoToReview(reviewDTO);
        if (request == null ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid argument");
        }
        try {
            Review review = reviewService.updateReview(reviewId, request);
            return ResponseEntity.status(HttpStatus.OK).body(review);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
