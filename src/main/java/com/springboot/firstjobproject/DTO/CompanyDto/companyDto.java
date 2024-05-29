package com.springboot.firstjobproject.DTO.CompanyDto;

import java.util.List;

import com.springboot.firstjobproject.DTO.JobDto.jobDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class companyDto {
    private Long id;
    private String name;
    private String email;
    private String website;
    private String description;
    private List<jobDto> jobList;
}
