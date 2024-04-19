package com.example.neo_tour.util;


import com.example.neo_tour.dto.BookingListRequestDto;
import com.example.neo_tour.dto.BookingResponseDto;
import com.example.neo_tour.entity.BookingRequest;

public class BookingMapper {

    public static BookingResponseDto toResponse(BookingRequest booking) {
        return new BookingResponseDto(
                booking.getId(),
                booking.getTour().getId(),
                booking.getTour().getTourName(),
                booking.getBookingRequestDate(),
                booking.getPhoneNumber(),
                booking.getComments()
        );
    }

    public static BookingListRequestDto toListRequest(BookingRequest booking) {
        return new BookingListRequestDto(
                booking.getId(),
                booking.getTour().getId(),
                booking.getTour().getImages().get(0).getImageUrl(),
                booking.getTour().getTourName()
        );
    }
}
