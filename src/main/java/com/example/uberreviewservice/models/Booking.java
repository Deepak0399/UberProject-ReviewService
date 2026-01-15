package com.example.uberreviewservice.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking extends BaseModel {

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Review review;
    @ManyToOne
    private Driver driver;
    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDistance;
}
