package com.example.neo_tour.dto;

public record BookingListRequestDto(Long bookingId, Long tourId, String imageUrl, String title) {
}
