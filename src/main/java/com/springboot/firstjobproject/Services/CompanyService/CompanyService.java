package com.springboot.firstjobproject.Services.CompanyService;

import java.util.List;

import com.springboot.firstjobproject.DTO.CompanyDto.companyDto;

public interface CompanyService {

    public List<companyDto> getAllCompanies();

    public companyDto getCompanyById(Long Id);

    public companyDto createNewCompany(companyDto company);

    public companyDto updateCompanyById(companyDto company, Long Id);

    public void deleteCompanyById(Long Id);
}
