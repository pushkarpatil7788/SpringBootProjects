package com.infosys.PostgreSqlRest.services;

import com.infosys.PostgreSqlRest.model.Employee;
import java.util.List;

public interface EmployeeServiceInterface {
    String createEmployee(Employee employee);
    String updateEmployee(Employee employee);
    String deleteEmployee(String employeeId);
    Employee getEmployee(String employeeId);
    List<Employee> getAllEmployees();
}
