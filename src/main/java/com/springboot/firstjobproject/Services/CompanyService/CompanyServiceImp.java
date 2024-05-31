package com.springboot.firstjobproject.Services.CompanyService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.firstjobproject.DTO.CompanyDto.companyDto;
import com.springboot.firstjobproject.Entities.CompanyEntity.CompanyEntity;
import com.springboot.firstjobproject.Repository.CompanyRepository.CompanyRepository;
import com.springboot.firstjobproject.Repository.JobRepository.jobRepository;

@Service
public class CompanyServiceImp implements CompanyService {
    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;
    private final jobRepository jobrepository;

    public CompanyServiceImp(ModelMapper modelMapper, CompanyRepository companyRepository,
            jobRepository jobrepository) {
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
        this.jobrepository = jobrepository;
    }

    @Override
    public List<companyDto> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(companyEntity -> modelMapper.map(companyEntity, companyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public companyDto getCompanyById(Long Id) {
        return modelMapper.map(companyRepository.findById(Id).get(), companyDto.class);
    }

    @Override
    public companyDto createNewCompany(companyDto company) {

        CompanyEntity companyEntity = modelMapper.map(company, CompanyEntity.class);

        return modelMapper.map(companyRepository.save(companyEntity), companyDto.class);
    }

    @Override
    public companyDto updateCompanyById(companyDto company, Long Id) {
        CompanyEntity companyEntity = companyRepository.findById(Id).get();
        if (Objects.nonNull(companyEntity.getName()) && !"".equalsIgnoreCase(company.getName())) {
            companyEntity.setName(company.getName());
        }
        if (Objects.nonNull(companyEntity.getEmail()) && !"".equalsIgnoreCase(company.getEmail())) {
            companyEntity.setEmail(company.getEmail());
        }
        if (Objects.nonNull(companyEntity.getWebsite()) && !"".equalsIgnoreCase(company.getWebsite())) {
            companyEntity.setWebsite(company.getWebsite());
        }
        if (Objects.nonNull(companyEntity.getDescription()) && !"".equalsIgnoreCase(company.getDescription())) {
            companyEntity.setDescription(company.getDescription());
        }

        return modelMapper.map(companyRepository.save(companyEntity), companyDto.class);// modelMapper.map(companyRepository.save(companyEntity),
        // getClass())

    }

    @Override
    public void deleteCompanyById(Long Id) {
        companyRepository.deleteById(Id);
    }

}
