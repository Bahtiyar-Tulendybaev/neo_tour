package com.example.neo_tour.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "booking_request")
public class BookingRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     Long id;

    @Column(name = "phone_number")
     String phoneNumber;

    @Column(name = "booking_request_date")
     LocalDate bookingRequestDate;

    @Column(name = "number_of_people")
     int numberOfPeople;

    @ManyToOne
    @JoinColumn(name = "tour_id")
     Tour tour;

    @Column(name = "comments", length = 200)
     String comments;
}
