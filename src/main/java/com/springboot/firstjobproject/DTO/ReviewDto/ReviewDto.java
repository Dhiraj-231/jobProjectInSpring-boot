package com.springboot.firstjobproject.DTO.ReviewDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDto {
    private Long id;
    private String tittle;
    private String description;
    private double rating;
    private Long jobId;
}
