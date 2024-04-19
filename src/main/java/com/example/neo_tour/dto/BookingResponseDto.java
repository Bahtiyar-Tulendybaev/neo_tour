package com.example.neo_tour.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record BookingResponseDto(
        Long bookingId,
        Long tourId,
        String title,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate date,
        String phoneNumber,
        String comment
) {
}
