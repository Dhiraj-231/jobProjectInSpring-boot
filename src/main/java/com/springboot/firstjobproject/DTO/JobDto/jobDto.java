package com.springboot.firstjobproject.DTO.JobDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class jobDto {
    private Long Id;
    private String tittle;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
}