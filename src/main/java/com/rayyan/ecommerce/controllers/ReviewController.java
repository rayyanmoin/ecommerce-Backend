package com.rayyan.ecommerce.controllers;

import com.rayyan.ecommerce.dto.ReviewAddDto;
import com.rayyan.ecommerce.dto.ReviewDto;
import com.rayyan.ecommerce.dto.ReviewEditDto;
import com.rayyan.ecommerce.dto.RolesEditDto;
import com.rayyan.ecommerce.ecommerceObjects.Review;
import com.rayyan.ecommerce.ecommerceObjects.Roles;
import com.rayyan.ecommerce.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reviews")
@CrossOrigin(origins = "http://localhost:3000")

public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/list")
    public List<ReviewDto> getReviewDto(){
        return reviewService.getReviewDto();
    }

    @PostMapping("/add")
    public String addReview(@RequestBody ReviewAddDto reviewAddDto) {
        return reviewService.addReview(reviewAddDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("id") Long id){
        Review review = reviewService.findReviewById(id);
        return ResponseEntity.ok(review);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Review> editReview(@PathVariable("id") Long id, @RequestBody ReviewEditDto reviewEditDto){
        Review updatedReview = reviewService.editReview(id, reviewEditDto);
        return ResponseEntity.ok(updatedReview);
    }


}
