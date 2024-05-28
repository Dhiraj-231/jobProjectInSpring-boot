package com.springboot.firstjobproject.Controllers.JobControlles;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.firstjobproject.DTO.JobDto.jobDto;
import com.springboot.firstjobproject.Services.JobService.JobServiceImp;

@RestController
@RequestMapping("/job")
public class JobController {

    private final JobServiceImp jobServiceImp;

    public JobController(JobServiceImp jobServiceImp) {
        this.jobServiceImp = jobServiceImp;
    }

    @GetMapping("/getAll")
    public List<jobDto> getFullJobs() {
        return jobServiceImp.getAllJobs();
    }

    // SECTION - get job by name
    @GetMapping("/get/{id}")
    public jobDto getJobById(@PathVariable("id") Long id) {
        return jobServiceImp.getJobById(id);
    }

    // SECTION - Create job
    @PostMapping("/create")
    public jobDto createJob(@RequestBody jobDto job) {
        return jobServiceImp.createNewJob(job);
    }

    // SECTION - Update job
    @PutMapping("/update/{id}")
    public jobDto updateJob(@PathVariable("id") Long id, @RequestBody jobDto job) {
        return jobServiceImp.updateJobById(job, id);
    }

    // SECTION - Delete job
    @DeleteMapping("/delete/{id}")
    public void deleteJob(@PathVariable("id") Long id) {
        jobServiceImp.deleteJobById(id);
    }

}
