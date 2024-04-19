package com.example.neo_tour.util;




import com.example.neo_tour.dto.CreateReviewDto;
import com.example.neo_tour.dto.ReviewDto;
import com.example.neo_tour.entity.Review;

import java.time.LocalDate;

public class ReviewMapper {

    public static ReviewDto toDto(Review review) {
        return new ReviewDto(
                review.getAuthorNickname(),
                review.getImageProfile().getImageUrl(),
                review.getReviewDate(),
                review.getText()
        );
    }

    public static Review fromDto(CreateReviewDto dto) {
        Review review = new Review();
        review.setAuthorNickname(dto.body());
        review.setReviewDate(LocalDate.now());
        review.setText(dto.text());

        return review;
    }
}
