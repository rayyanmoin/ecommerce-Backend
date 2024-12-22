package com.rayyan.ecommerce.service;

import com.rayyan.ecommerce.dto.ReviewAddDto;
import com.rayyan.ecommerce.dto.ReviewDto;
import com.rayyan.ecommerce.dto.ReviewEditDto;
import com.rayyan.ecommerce.dto.RolesEditDto;
import com.rayyan.ecommerce.ecommerceObjects.Review;
import com.rayyan.ecommerce.ecommerceObjects.Roles;
import com.rayyan.ecommerce.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;


    public List<ReviewDto> getReviewDto(){
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewDto> reviewDtos = new ArrayList<>();
        for(Review review: reviews){
            ReviewDto reviewDto = new ReviewDto();
            reviewDto.setId(review.getId());
            reviewDto.setProductName(review.getProduct().getName());
            reviewDto.setUserName(review.getUser().getUsername());
            reviewDto.setRating(review.getRating());
            reviewDto.setComment(review.getComment());
            reviewDto.setCreatedAt(review.getCreatedAt());
            reviewDtos.add(reviewDto);
        }
        return reviewDtos;
    }


    public String addReview(ReviewAddDto reviewAddDto){
        Review review = new Review();
        review.setProductId(reviewAddDto.getProductId());
        review.setUserId(reviewAddDto.getUserId());
        review.setRating(reviewAddDto.getRating());
        review.setComment(reviewAddDto.getComment());
        review.setCreatedAt(reviewAddDto.getCreatedAt());
        reviewRepository.save(review);
        return "Review added Successfully";

    }

    public Review findReviewById(Long id){
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found"));
    }


    public Review editReview(Long id, ReviewEditDto reviewEditDto) {

        Review existingReview = findReviewById(id);
        existingReview.setUserId(reviewEditDto.getUserId());
        existingReview.setProductId(reviewEditDto.getProductId());
        existingReview.setRating(reviewEditDto.getRating());
        existingReview.setComment(reviewEditDto.getComment());
        existingReview.setCreatedAt(reviewEditDto.getCreatedAt());

        return reviewRepository.save(existingReview);
    }


}
