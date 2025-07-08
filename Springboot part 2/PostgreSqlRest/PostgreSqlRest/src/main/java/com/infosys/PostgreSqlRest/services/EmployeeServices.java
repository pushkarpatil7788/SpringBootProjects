package com.infosys.PostgreSqlRest.services;

import com.infosys.PostgreSqlRest.model.Employee;
import com.infosys.PostgreSqlRest.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String createEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "Employee created successfully!";
    }

    @Override
    public String updateEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "Employee updated successfully!";
    }

    @Override
    public String deleteEmployee(String employeeId) {
        employeeRepo.deleteById(employeeId);
        return "Employee deleted successfully!";
    }

    @Override
    public Employee getEmployee(String employeeId) {
        Optional<Employee> optional = employeeRepo.findById(employeeId);
        return optional.orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }
}
