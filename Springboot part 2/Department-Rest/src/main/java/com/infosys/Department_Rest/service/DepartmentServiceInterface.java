package com.infosys.Department_Rest.service;

import com.infosys.Department_Rest.Model.Department;

import java.util.List;

public interface DepartmentServiceInterface {
    Department saveDepartment(Department department);
    Department getDepartmentById(Long departmentId);
    List<Department> getAllDepartments();

}