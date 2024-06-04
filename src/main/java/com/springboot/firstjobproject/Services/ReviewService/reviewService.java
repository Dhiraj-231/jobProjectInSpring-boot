package com.springboot.firstjobproject.Services.ReviewService;

import java.util.List;
import com.springboot.firstjobproject.DTO.ReviewDto.ReviewDto;

public interface reviewService {
    List<ReviewDto> getAllReviews(Long companyId);

    ReviewDto addReview(Long companyId, ReviewDto reviewDto);
}
