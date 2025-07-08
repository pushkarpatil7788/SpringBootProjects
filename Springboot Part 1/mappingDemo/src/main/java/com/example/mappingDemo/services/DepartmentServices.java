package com.example.mappingDemo.services;

import com.example.mappingDemo.beans.Departments;
import com.example.mappingDemo.repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServices implements DepartmentServicesInterface {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public void saveDepartment(Departments department) {
        departmentRepo.save(department);
    }

    @Override
    public List<Departments> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Departments findDepartment(int id) {
        Optional<Departments> optional = departmentRepo.findById(id);
        return optional.orElse(null);
    }
}
