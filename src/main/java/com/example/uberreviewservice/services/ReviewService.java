package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("**********");
        Review r = Review.builder()
                .content("good riding")
                .rating(4.5) // Code to create only java object
                .build();
        reviewRepository.save(r);// this line of code responsible for saving the object in database using sql queries...
        List<Review> reviews = reviewRepository.findAll();
        for (Review review : reviews) {
            System.out.println(review.getContent());
        }
//        reviewRepository.deleteById(4L);
    }
}
