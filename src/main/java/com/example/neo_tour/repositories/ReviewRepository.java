package com.example.neo_tour.repositories;


import com.example.neo_tour.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByTourId(Long tourId, Pageable pageable);
}
