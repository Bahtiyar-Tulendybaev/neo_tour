package com.example.neo_tour.dto;

import org.hibernate.validator.constraints.Length;

public record CreateReviewDto(
        Long tourId,
        @Length(min = 10, max = 300, message = "Review should be between 10 and 300 characters")
        String body,
        String text) {
}
