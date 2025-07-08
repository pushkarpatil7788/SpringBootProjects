package com.infosys.employeeperformancemanagementsystem.service;

import java.util.List;

public interface EmployeeServiceInterface {
    void addEmployee(String name, double salary, int rating, int deptId);
    void assignProjects(int empId, List<Integer> projectIds);
}
