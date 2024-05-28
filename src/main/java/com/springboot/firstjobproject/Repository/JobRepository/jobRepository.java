package com.springboot.firstjobproject.Repository.JobRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.firstjobproject.Entities.JobEntity.JobEntity;

@Repository
public interface jobRepository extends JpaRepository<JobEntity, Long> {

}
