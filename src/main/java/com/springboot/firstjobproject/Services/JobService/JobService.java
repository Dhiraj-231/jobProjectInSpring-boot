package com.springboot.firstjobproject.Services.JobService;

import java.util.List;

import com.springboot.firstjobproject.DTO.JobDto.jobDto;

public interface JobService {

    public jobDto createNewJob(jobDto jobDto);

    public List<jobDto> getAllJobs();

    public jobDto getJobById(Long Id);

    public jobDto updateJobById(jobDto jobDto, Long Id);

    public void deleteJobById(Long Id);
}
