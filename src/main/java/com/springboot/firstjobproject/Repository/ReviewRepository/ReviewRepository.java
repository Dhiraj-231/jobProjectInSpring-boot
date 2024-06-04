package com.springboot.firstjobproject.Repository.ReviewRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.firstjobproject.Entities.ReviewEntity.ReviewEntity;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    List<ReviewEntity> findByCompanyId(Long companyId);

}
