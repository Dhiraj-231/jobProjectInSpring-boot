package com.springboot.firstjobproject.Controllers.JobControlles;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<jobDto>> getFullJobs() {
        return new ResponseEntity<>(jobServiceImp.getAllJobs(), HttpStatus.OK);
    }

    // SECTION - get job by name
    @GetMapping("/get/{id}")
    public ResponseEntity<jobDto> getJobById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(jobServiceImp.getJobById(id), HttpStatus.OK);
    }

    // SECTION - Create job
    @PostMapping("/create")
    public ResponseEntity<jobDto> createJob(@RequestBody jobDto job) {
        return new ResponseEntity<>(jobServiceImp.createNewJob(job), HttpStatus.CREATED);
    }

    // SECTION - Update job
    @PutMapping("/update/{id}")
    public ResponseEntity<jobDto> updateJob(@PathVariable("id") Long id, @RequestBody jobDto job) {
        return new ResponseEntity<>(jobServiceImp.updateJobById(job, id), HttpStatus.OK);
    }

    // SECTION - Delete job
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Long id) {
        jobServiceImp.deleteJobById(id);

        return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
    }

}
