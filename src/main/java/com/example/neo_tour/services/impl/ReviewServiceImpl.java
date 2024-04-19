package com.example.neo_tour.services.impl;


import com.example.neo_tour.dto.CreateReviewDto;
import com.example.neo_tour.dto.ReviewDto;
import com.example.neo_tour.entity.Review;
import com.example.neo_tour.exceptions.NotFoundException;
import com.example.neo_tour.repositories.ReviewRepository;
import com.example.neo_tour.repositories.TourRepository;
import com.example.neo_tour.services.ImageService;
import com.example.neo_tour.services.ReviewService;
import com.example.neo_tour.util.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final TourRepository tourRepository;
    private final ReviewRepository reviewRepository;
    private final ImageService imageService;

    @Override
    public void addReview(CreateReviewDto json, MultipartFile image) {
        Review review = ReviewMapper.fromDto(json);
        review.setTour(tourRepository.findById(json.tourId()).orElseThrow());
        review.setImageProfile(imageService.processImage(image));

        reviewRepository.save(review);
    }

    @Override
    public Page<ReviewDto> getReviewsByTourId(Long tourId, int page, int size) {
        if (!tourRepository.existsById(tourId)) {
            throw new NotFoundException("Booking not found");
        }
        return reviewRepository.findAllByTourId(tourId, PageRequest.of(page, size)).map(ReviewMapper::toDto);
    }
}
