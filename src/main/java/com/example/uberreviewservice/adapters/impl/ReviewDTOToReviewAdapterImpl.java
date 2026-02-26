package com.example.uberreviewservice.adapters.impl;

import com.example.uberreviewservice.adapters.ReviewDTOToReviewAdapter;
import com.example.uberreviewservice.dtos.ReviewDTO;
import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReviewDTOToReviewAdapterImpl implements ReviewDTOToReviewAdapter {

    private final BookingRepository bookingRepository;
    @Override
    public Review convertReviewDtoToReview(ReviewDTO reviewDTO) {
        Optional<Booking> booking = bookingRepository.findById(reviewDTO.getBookingId());

        return booking.map(value -> Review.builder()
                .comment(reviewDTO.getComment())
                .rating(reviewDTO.getRating())
                .booking(value)
                .build()).orElse(null);
    }
}
