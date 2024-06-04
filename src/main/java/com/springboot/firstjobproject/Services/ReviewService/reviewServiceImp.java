package com.springboot.firstjobproject.Services.ReviewService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.firstjobproject.DTO.CompanyDto.companyDto;
import com.springboot.firstjobproject.DTO.ReviewDto.ReviewDto;
import com.springboot.firstjobproject.Entities.CompanyEntity.CompanyEntity;
import com.springboot.firstjobproject.Entities.JobEntity.JobEntity;
import com.springboot.firstjobproject.Entities.ReviewEntity.ReviewEntity;
import com.springboot.firstjobproject.Repository.ReviewRepository.ReviewRepository;
import com.springboot.firstjobproject.Services.CompanyService.CompanyServiceImp;
import com.springboot.firstjobproject.Services.JobService.JobServiceImp;

@Service
public class reviewServiceImp implements reviewService {
    private ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;
    private final CompanyServiceImp companyServiceImp;
    private final JobServiceImp jobServiceImp;

    public reviewServiceImp(ReviewRepository reviewRepository, ModelMapper modelMapper,
            CompanyServiceImp companyServiceImp, JobServiceImp jobServiceImp) {
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
        this.companyServiceImp = companyServiceImp;
        this.jobServiceImp = jobServiceImp;
    }

    @Override
    public List<ReviewDto> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId)
                .stream()
                .map(entity -> modelMapper.map(entity, ReviewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDto addReview(Long companyId, ReviewDto reviewDto) {
        JobEntity jobEntity = modelMapper.map(jobServiceImp.getJobById(reviewDto.getJobId()), JobEntity.class);

        ReviewEntity reviewEntity = modelMapper.map(reviewDto, ReviewEntity.class);
        reviewEntity.setCompany(modelMapper.map(companyServiceImp.getCompanyById(companyId), CompanyEntity.class));
        reviewEntity.setJob(jobEntity);
        reviewEntity = reviewRepository.save(reviewEntity);
        return modelMapper.map(reviewEntity, ReviewDto.class);
    }
}
