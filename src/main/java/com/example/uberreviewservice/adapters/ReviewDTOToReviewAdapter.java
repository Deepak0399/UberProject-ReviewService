package com.example.uberreviewservice.adapters;

import com.example.uberreviewservice.dtos.ReviewDTO;
import com.example.uberreviewservice.models.Review;
import org.springframework.stereotype.Component;

@Component
public interface ReviewDTOToReviewAdapter {
    public Review convertReviewDtoToReview(ReviewDTO reviewDTO);
}
