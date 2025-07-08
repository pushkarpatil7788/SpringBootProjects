package com.infosys.employeeperformancemanagementsystem.service;

import com.infosys.employeeperformancemanagementsystem.entity.Employee;
import com.infosys.employeeperformancemanagementsystem.entity.PerformanceReview;
import com.infosys.employeeperformancemanagementsystem.repository.EmployeeRepo;
import com.infosys.employeeperformancemanagementsystem.repository.PerformanceReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PerformanceReviewService implements PerformanceReviewServiceInterface {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PerformanceReviewRepo reviewRepo;

    @Override
    public void addReview(int empId, int rating, String remarks) {
        Employee emp = employeeRepo.findById(empId).orElse(null);
        if (emp == null) {
            System.out.println("Employee not found.");
            return;
        }
        PerformanceReview review = new PerformanceReview();
        review.setRating(rating);
        review.setRemarks(remarks);
        review.setReviewDate(LocalDate.now());
        review.setEmployee(emp);
        reviewRepo.save(review);
        System.out.println("Review added successfully.");
    }

    @Override
    public void listReviewsByEmployee(int empId) {
        List<PerformanceReview> reviews = reviewRepo.findByEmployeeId(empId);
        if (reviews.isEmpty()) {
            System.out.println("No reviews found.");
        } else {
            reviews.forEach(System.out::println);
        }
    }
}
