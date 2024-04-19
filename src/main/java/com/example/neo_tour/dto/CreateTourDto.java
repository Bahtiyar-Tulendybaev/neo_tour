package com.example.neo_tour.dto;

public record CreateTourDto(
        String name,
        String place,
        String country,
        String continent,
        int[] seasons,
        String description,
        boolean isSpecial
) {
}
