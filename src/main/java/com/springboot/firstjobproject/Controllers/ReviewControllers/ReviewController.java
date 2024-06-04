package com.springboot.firstjobproject.Controllers.ReviewControllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.firstjobproject.DTO.ReviewDto.ReviewDto;
import com.springboot.firstjobproject.Services.ReviewService.reviewServiceImp;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private reviewServiceImp ReviewService;

    public ReviewController(reviewServiceImp ReviewService) {
        this.ReviewService = ReviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewDto>> getAllReviews(@PathVariable Long companyId) {
        List<ReviewDto> reviews = ReviewService.getAllReviews(companyId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/reviews")
    public ResponseEntity<ReviewDto> addReview(@PathVariable Long companyId, @RequestBody ReviewDto reviewDto) {
        return new ResponseEntity<>(ReviewService.addReview(companyId, reviewDto), HttpStatus.CREATED);

    }
}
