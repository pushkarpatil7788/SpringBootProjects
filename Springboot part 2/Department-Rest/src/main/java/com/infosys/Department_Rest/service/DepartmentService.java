package com.infosys.Department_Rest.service;

import com.infosys.Department_Rest.Model.Department;
import com.infosys.Department_Rest.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements DepartmentServiceInterface {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        Optional<Department> optionalDepartment = departmentRepo.findById(departmentId);
        return optionalDepartment.orElse(null);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

}