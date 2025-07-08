package com.infosys.employeeperformancemanagementsystem.service;

import com.infosys.employeeperformancemanagementsystem.entity.Department;
import com.infosys.employeeperformancemanagementsystem.entity.Employee;
import com.infosys.employeeperformancemanagementsystem.entity.Project;
import com.infosys.employeeperformancemanagementsystem.repository.DepartmentRepo;
import com.infosys.employeeperformancemanagementsystem.repository.EmployeeRepo;
import com.infosys.employeeperformancemanagementsystem.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public void addEmployee(String name, double salary, int rating, int deptId) {
        Employee emp = new Employee();
        emp.setName(name);
        emp.setSalary(salary);
        emp.setRating(rating);

        Optional<Department> dept = departmentRepo.findById(deptId);
        if (dept.isPresent()) {
            emp.setDepartment(dept.get());
            employeeRepo.save(emp);
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Department not found.");
        }
    }

    @Override
    public void assignProjects(int empId, List<Integer> projectIds) {
        Optional<Employee> optEmp = employeeRepo.findById(empId);
        if (optEmp.isPresent()) {
            Employee emp = optEmp.get();
            Set<Project> projectSet = new HashSet<>();
            for (Integer pid : projectIds) {
                Optional<Project> project = projectRepo.findById(pid);
                project.ifPresent(projectSet::add);
            }
            emp.setProjects(projectSet);
            employeeRepo.save(emp);
            System.out.println("Projects assigned successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}
