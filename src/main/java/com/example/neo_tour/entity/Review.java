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
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     Long id;

    @ManyToOne
    @JoinColumn(name = "tour_id")
     Tour tour;

    @Column(name = "review_date")
     LocalDate reviewDate;

    @Column(name = "author_nickname")
     String authorNickname;

    @ManyToOne
    @JoinColumn(name = "image_id")
     Image imageProfile;

    @Column(name = "text", length = 300)
     String text;
}
