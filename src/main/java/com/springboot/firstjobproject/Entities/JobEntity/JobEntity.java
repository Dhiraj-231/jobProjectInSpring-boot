package com.springboot.firstjobproject.Entities.JobEntity;

import java.util.List;
import com.springboot.firstjobproject.Entities.CompanyEntity.CompanyEntity;
import com.springboot.firstjobproject.Entities.ReviewEntity.ReviewEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @JoinColumn(name = "company_id", referencedColumnName = "Company_Id")
    private CompanyEntity company;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private List<ReviewEntity> reviews;

}
