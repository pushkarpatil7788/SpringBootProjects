package com.infosys.mappdemo2.services;

import com.infosys.mappdemo2.beans.Department;
import com.infosys.mappdemo2.repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServices implements DepartmentServicesInterface{

    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public void saveDepartment(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    public Department findDepartment(int deptId) {
        return departmentRepo.findById(deptId).get();
    }
}
