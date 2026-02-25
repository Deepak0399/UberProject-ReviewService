package com.example.uberreviewservice.controllers;

import com.example.uberreviewservice.dtos.ReviewDTO;
import com.example.uberreviewservice.models.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/reviews")
public class ReviewController {

    public ResponseEntity<Review> createReview(@RequestBody ReviewDTO reviewDTO){

        return null;
    }
}
