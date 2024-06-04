package com.springboot.firstjobproject.Entities.ReviewEntity;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;

import com.springboot.firstjobproject.Entities.CompanyEntity.CompanyEntity;
import com.springboot.firstjobproject.Entities.JobEntity.JobEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;
    private String description;
    private double rating;
    @ManyToOne
    private CompanyEntity company;
    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "Job_Id")
    private JobEntity job;
}
