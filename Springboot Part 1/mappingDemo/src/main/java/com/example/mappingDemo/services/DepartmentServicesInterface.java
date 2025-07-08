package com.example.mappingDemo.services;

import com.example.mappingDemo.beans.Departments;
import java.util.List;

public interface DepartmentServicesInterface {
    void saveDepartment(Departments department);
    List<Departments> getAllDepartments();
    Departments findDepartment(int id); // ✅ ADD THIS
}
