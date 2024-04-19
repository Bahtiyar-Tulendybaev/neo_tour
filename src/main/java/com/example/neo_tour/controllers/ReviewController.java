package com.example.neo_tour.controllers;

import com.example.neo_tour.dto.CreateReviewDto;
import com.example.neo_tour.dto.ReviewDto;
import com.example.neo_tour.services.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reviews")
@CrossOrigin("*")
@Tag(name = "Review controller")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/add-review")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReview(@ModelAttribute CreateReviewDto dto, @RequestPart("images") MultipartFile image) {
        reviewService.addReview(dto, image);
    }

    @GetMapping("/{tourId}")
    @Operation(
            summary = "Get all reviews by tour id",
            description = "Get all reviews by tour id",
            tags = {"review", "get"},
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "404", description = "Tour not found", content = @Content)
            }
    )
    public ResponseEntity<Page<ReviewDto>> getReviewsByTourId(
            @PathVariable Long tourId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(reviewService.getReviewsByTourId(tourId, page, size));
    }
}
