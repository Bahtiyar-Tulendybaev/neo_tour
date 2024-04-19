package com.example.neo_tour.services;



import com.example.neo_tour.dto.BookingRequestDto;
import com.example.neo_tour.dto.BookingResponseDto;

import java.util.List;

public interface BookingRequestService {
    void addBookingRequest(BookingRequestDto requestDto);

    BookingResponseDto getBooking(Long id);

    List<BookingResponseDto> getBookings();

    void deleteBookingRequest(Long id);
}
