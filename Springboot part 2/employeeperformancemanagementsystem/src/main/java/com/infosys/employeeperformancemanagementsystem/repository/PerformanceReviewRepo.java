package com.infosys.employeeperformancemanagementsystem.repository;

import com.infosys.employeeperformancemanagementsystem.entity.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceReviewRepo extends JpaRepository<PerformanceReview,Integer> {
    List<PerformanceReview> findByEmployeeId(int employeeId);
}
