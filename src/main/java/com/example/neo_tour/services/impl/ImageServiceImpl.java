package com.example.neo_tour.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import com.example.neo_tour.entity.Image;
import com.example.neo_tour.repositories.ImageRepository;
import com.example.neo_tour.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final Cloudinary cloudinary;

    @Override
    public Image processImage(MultipartFile file) {
        return saveImage(file);
    }

    @Override
    public Image saveImage(MultipartFile file) {
        String imageUrl = uploadImage(file);
        Image image = new Image();
        image.setImageUrl(imageUrl);
        image.setImageName(file.getOriginalFilename());
        return imageRepository.save(image);
    }

    @Override
    public String uploadImage(MultipartFile file) {
        try {
            return cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url").toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
