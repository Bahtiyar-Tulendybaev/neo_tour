package com.example.neo_tour.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
     Long id;

    @Column(name = "place")
     String place;

    @Column(name = "country")
     String country;

    @Column(name = "continent")
     String continent;

    @OneToMany(mappedBy = "location")
     List<Tour> tours;

    public Location(String place, String country, String continent) {
        this.place = place;
        this.country = country;
        this.continent = continent;
    }
}
