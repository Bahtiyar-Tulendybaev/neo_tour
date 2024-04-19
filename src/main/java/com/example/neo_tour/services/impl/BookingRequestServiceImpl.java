package com.example.neo_tour.services.impl;


import com.example.neo_tour.dto.BookingRequestDto;
import com.example.neo_tour.dto.BookingResponseDto;
import com.example.neo_tour.entity.BookingRequest;
import com.example.neo_tour.entity.Tour;
import com.example.neo_tour.exceptions.NotFoundException;
import com.example.neo_tour.repositories.BookingRequestRepository;
import com.example.neo_tour.repositories.TourRepository;
import com.example.neo_tour.services.BookingRequestService;
import com.example.neo_tour.util.BookingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookingRequestServiceImpl implements BookingRequestService {

    private final TourRepository tourRepository;
    private final BookingRequestRepository bookingRequestRepository;


    @Override
    @Transactional
    public void addBookingRequest(BookingRequestDto requestDto) {
        Tour tour = tourRepository.findById(requestDto.tourId()).orElseThrow();
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setTour(tour);
        bookingRequest.setBookingRequestDate(LocalDate.now());
        bookingRequest.setNumberOfPeople(requestDto.numberOfPeople());
        bookingRequest.setPhoneNumber(requestDto.phoneNumber());
        bookingRequest.setComments(requestDto.comment());
        bookingRequestRepository.save(bookingRequest);
        tourRepository.incrementBookingCount(bookingRequest.getTour().getId());
        BookingMapper.toResponse(bookingRequest);
    }

    @Override
    public BookingResponseDto getBooking(Long id) {
        return BookingMapper.toResponse(bookingRequestRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Booking not found")));
    }

    @Override
    public List<BookingResponseDto> getBookings() {
        List<BookingRequest> responseDtos = bookingRequestRepository.findAll();
        return responseDtos.stream().map(BookingMapper::toResponse).toList();
    }

    @Override
    public void deleteBookingRequest(Long id) {
        try {
            bookingRequestRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException("Booking not found");
        }
    }
}
