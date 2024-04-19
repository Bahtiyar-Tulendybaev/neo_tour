package com.example.neo_tour.services;


import com.example.neo_tour.entity.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Image processImage(MultipartFile file);

    Image saveImage(MultipartFile file);

    String uploadImage(MultipartFile file);
}
