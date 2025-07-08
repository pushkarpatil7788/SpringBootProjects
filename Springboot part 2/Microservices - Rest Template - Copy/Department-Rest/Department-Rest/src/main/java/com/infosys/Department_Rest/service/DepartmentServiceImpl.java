package com.infosys.Department_Rest.service;

import com.infosys.Department_Rest.model.Departments;
import com.infosys.Department_Rest.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository drepository;

    @Override
    public Departments saveDepartment(Departments department) {

        return drepository.save(department);
    }

    @Override
    public Departments getDepartmentById(Long departmentid) {

        return drepository.findById(departmentid).get();
    }
}
