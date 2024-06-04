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

    /**
     * Creates a new company using the provided companyDTO object.
     *
     * @param company - the companyDTO object containing the new company's values
     * @return the newly created companyDTO object
     */
    @Override
    public companyDto createNewCompany(companyDto company) {

        // Convert the companyDTO object to a CompanyEntity object
        CompanyEntity companyEntity = modelMapper.map(company, CompanyEntity.class);
        // corresponding companyDTO object
        return modelMapper.map(companyRepository.save(companyEntity), companyDto.class);
    }

    /**
     * Updates a company by its ID with the provided companyDTO object.
     * Only updates the fields that are not null or empty.
     *
     * @param company - the companyDTO object containing the updated values
     * @param Id      - the ID of the company to be updated
     * @return the updated companyDTO object
     */
    @Override
    public companyDto updateCompanyById(companyDto company, Long Id) {
        // Find the company by its ID
        CompanyEntity companyEntity = companyRepository.findById(Id).get();
        // Update the fields that are not null or empty
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

        // Save the updated company entity and return the updated companyDTO object
        return modelMapper.map(companyRepository.save(companyEntity), companyDto.class);
    }

    /**
     * Deletes a company by its ID.
     *
     * @param Id - the ID of the company to be deleted
     */
    @Override
    public void deleteCompanyById(Long Id) {
        // Delete the company entity with the given ID
        companyRepository.deleteById(Id);
    }

}
