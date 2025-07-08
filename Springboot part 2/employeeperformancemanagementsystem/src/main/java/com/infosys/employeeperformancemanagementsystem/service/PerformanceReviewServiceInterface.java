package com.infosys.employeeperformancemanagementsystem.service;

public interface PerformanceReviewServiceInterface {
    void addReview(int empId, int rating, String remarks);
    void listReviewsByEmployee(int empId);

}
