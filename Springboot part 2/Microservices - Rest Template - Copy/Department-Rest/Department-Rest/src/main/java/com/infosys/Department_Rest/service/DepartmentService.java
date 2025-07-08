package com.infosys.Department_Rest.service;

import com.infosys.Department_Rest.model.Departments;

public interface DepartmentService {
    Departments saveDepartment(Departments department);
    Departments getDepartmentById(Long departmentid);
}
