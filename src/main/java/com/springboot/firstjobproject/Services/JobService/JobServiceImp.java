package com.springboot.firstjobproject.Services.JobService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.firstjobproject.DTO.JobDto.jobDto;
import com.springboot.firstjobproject.Entities.JobEntity.JobEntity;
import com.springboot.firstjobproject.Repository.JobRepository.jobRepository;

@Service
public class JobServiceImp implements JobService {

    private final ModelMapper modelMapper;
    private final jobRepository jobRepository;

    public JobServiceImp(ModelMapper modelMapper, jobRepository jobRepository) {
        this.modelMapper = modelMapper;
        this.jobRepository = jobRepository;
    }

    // !SECTION- get one job Post
    @Override
    public jobDto getJobById(Long Id) {
        return modelMapper.map(jobRepository.findById(Id).get(), jobDto.class);
    }

    // !SECTION- Create New Job
    @Override
    public jobDto createNewJob(jobDto jobDto) {
        JobEntity jobEntity = modelMapper.map(jobDto, JobEntity.class);

        return modelMapper.map(jobRepository.save(jobEntity), jobDto.class);
    }

    // !SECTION- Get All Jobs
    @Override
    public List<jobDto> getAllJobs() {
        return jobRepository
                .findAll()
                .stream()
                .map(jobEntity -> modelMapper.map(jobEntity, jobDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Updates a job entity with the provided jobDTO based on the given Id.
     * If the provided jobDTO contains a non-empty value for any of the
     * fields, it updates the corresponding field of the jobEntity.
     * 
     * @param jobDto - The jobDTO containing the updated values
     * @param Id     - The Id of the jobEntity to be updated
     * @return jobDto - The updated jobDTO
     */

    @Override
    public jobDto updateJobById(jobDto jobDto, Long Id) {
        JobEntity jobEntity = jobRepository.findById(Id).get(); // Find the jobEntity by Id

        // Update the fields of jobEntity if the corresponding field in jobDto is
        // non-empty
        if (Objects.nonNull(jobEntity.getTittle()) && !"".equalsIgnoreCase(jobDto.getTittle())) {
            jobEntity.setTittle(jobDto.getTittle()); // Update the title
        }

        if (Objects.nonNull(jobEntity.getDescription()) && !"".equalsIgnoreCase(jobDto.getDescription())) {
            jobEntity.setDescription(jobDto.getDescription()); // Update the description
        }

        if (Objects.nonNull(jobEntity.getMinSalary()) && !"".equalsIgnoreCase(jobDto.getMinSalary())) {
            jobEntity.setMinSalary(jobDto.getMinSalary()); // Update the minimum salary
        }
        if (Objects.nonNull(jobEntity.getMaxSalary()) && !"".equalsIgnoreCase(jobDto.getMaxSalary())) {
            jobEntity.setMaxSalary(jobDto.getMaxSalary()); // Update the maximum salary
        }
        if (Objects.nonNull(jobEntity.getLocation()) && !"".equalsIgnoreCase(jobDto.getLocation())) {
            jobEntity.setLocation(jobDto.getLocation()); // Update the location
        }

        return modelMapper.map(jobRepository.save(jobEntity), jobDto.class); // Save the updated jobEntity and return //
                                                                             // the updated jobDTO

    }

    @Override
    public void deleteJobById(Long Id) {
        jobRepository.deleteById(Id);
    }

}
