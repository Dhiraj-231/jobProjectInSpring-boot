package com.springboot.firstjobproject.Controllers.CompanyControlles;

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
import java.util.List;
import com.springboot.firstjobproject.DTO.CompanyDto.companyDto;
import com.springboot.firstjobproject.Services.CompanyService.CompanyServiceImp;

@RestController
@RequestMapping("/Company")
public class CompanyControllers {
    private final CompanyServiceImp companyServiceImp;

    public CompanyControllers(CompanyServiceImp companyServiceImp) {
        this.companyServiceImp = companyServiceImp;
    }

    // !SECTION - Get All Companies
    @GetMapping("/getAll")
    public ResponseEntity<List<companyDto>> getCompanyDetail() {
        return new ResponseEntity<>(companyServiceImp.getAllCompanies(), HttpStatus.OK);
    }

    // !SECTION - Get Company by Id
    @GetMapping("/get/{id}")
    public ResponseEntity<companyDto> getCompanyById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(companyServiceImp.getCompanyById(id), HttpStatus.OK);
    }

    // !SECTION - Create Company
    @PostMapping("/create")
    public ResponseEntity<companyDto> createCompany(@RequestBody companyDto company) {
        return new ResponseEntity<>(companyServiceImp.createNewCompany(company), HttpStatus.CREATED);
    }

    // SECTION - Update Company
    @PutMapping("/update/{id}")
    public ResponseEntity<companyDto> updateCompany(@PathVariable("id") Long id, @RequestBody companyDto company) {
        return new ResponseEntity<>(companyServiceImp.updateCompanyById(company, id), HttpStatus.OK);
    }

    // SECTION - Delete Company
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable("id") Long id) {
        companyServiceImp.deleteCompanyById(id);
        return new ResponseEntity<>("Company Deleted Successfully", HttpStatus.OK);
    }
}
