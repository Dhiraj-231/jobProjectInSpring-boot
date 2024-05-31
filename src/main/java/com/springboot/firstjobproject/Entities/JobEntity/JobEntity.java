package com.springboot.firstjobproject.Entities.JobEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.firstjobproject.Entities.CompanyEntity.CompanyEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_details")
public class JobEntity {
    @Id
    @Column(name = "Job_Id")
    private Long Id;
    @Column(name = "Job_Tittle")
    private String tittle;
    @Column(name = "Job_Description")
    private String description;
    @Column(name = "Job_Min_Salary")
    private String minSalary;
    @Column(name = "Job_Max_Salary")
    private String maxSalary;
    @Column(name = "Job_Location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @JsonIgnoreProperties("jobList")
    private CompanyEntity company;

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    // !SECTION- Entity constructor
    public JobEntity(Long id, String tittle, String description, String minSalary, String maxSalary, String location,
            CompanyEntity company) {
        Id = id;
        this.tittle = tittle;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
        this.company = company;
    }

    public JobEntity() {
        super();
    }
    // NOTE - getters and setters

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "JobEntity [Id=" + Id + ", tittle=" + tittle + ", description=" + description + ", minSalary="
                + minSalary + ", maxSalary=" + maxSalary + ", location=" + location + ", company=" + company + "]";
    }
}
