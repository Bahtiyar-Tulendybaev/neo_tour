package com.example.neo_tour.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "tour_name")
    String tourName;

    @Column(name = "description", length = 750)
    String description;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "location_id")
    Location location;

    @Column(name = "recommended_seasons")
    Integer recommendedSeasons;

    @OneToMany
    @JoinTable(
            name = "tour_image",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    List<Image> images;

    @OneToMany(mappedBy = "tour")
    List<Review> reviews;

    @Column(name = "is_special")
    boolean isSpecial;

    @Column(name = "booking_count")
    int bookingCount;

    @Column(name = "view_count")
    int viewCount;

    public void addImage(Image image) {
        if (images == null) {
            images = new ArrayList<>();
        }
        images.add(image);
    }
}
