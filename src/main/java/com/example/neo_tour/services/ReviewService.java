package com.example.neo_tour.services;

import com.example.neo_tour.dto.CreateReviewDto;
import com.example.neo_tour.dto.ReviewDto;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface ReviewService {
    void addReview(CreateReviewDto json, MultipartFile image);
    Page<ReviewDto> getReviewsByTourId(Long tourId, int page, int size);

}
