package com.springboot.firstjobproject.Entities.CompanyEntity;

import java.util.List;

import com.springboot.firstjobproject.Entities.JobEntity.JobEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Company_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyEntity {

    @Id
    @Column(name = "Company_Id")
    private Long id;
    @Column(name = "Company_Name")
    private String name;
    @Column(name = "Company_Email")
    private String email;
    @Column(name = "Company_Website")
    private String website;
    @Column(name = "Company_Description")
    private String description;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<JobEntity> jobList;
    // list of Reviews of companies with one to many relationship
}
