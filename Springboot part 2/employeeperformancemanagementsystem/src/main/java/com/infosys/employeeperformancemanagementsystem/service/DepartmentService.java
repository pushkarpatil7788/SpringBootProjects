package com.infosys.employeeperformancemanagementsystem.service;

import com.infosys.employeeperformancemanagementsystem.entity.Department;
import com.infosys.employeeperformancemanagementsystem.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements DepartmentServiceInterface {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public void addDepartment(String Depname) {
        Department department = new Department();
        department.setDepartmentName(Depname);
        departmentRepo.save(department);
        System.out.println("Department added successfully.");
    }
}
