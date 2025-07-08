package com.infosys.employeemanagement2.services;
import com.infosys.employeemanagement2.beans.Employees;
import java.util.List;
import java.util.Optional;

public interface EmployeeServicesInterface {
    void addEmployees(Employees employee);
    Optional<Employees> findEmployeeById(int EmployeeId);
    void updateEmployee(Employees employee);  // Add this line
    void deleteEmployee(int EmployeeId);
    List<Employees> getEmployeesByDepartment(String department);
    List<Employees> getEmployeesByRole(String role);
    List<Employees> getEmployeesByLocation(String location);
}
