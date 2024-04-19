package com.example.neo_tour.dto;

import java.util.List;

public record TourDto(
        Long id,
        String name,
        String place,
        String country,
        String description,
        List<String> images,
        List<ReviewDto> reviewDtoList) {
}
