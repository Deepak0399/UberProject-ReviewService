package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookingreview")
public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;

    private Double rating;
}
