package com.infosys.PostgreSqlRest.controller;

import com.infosys.PostgreSqlRest.model.Employee;
import com.infosys.PostgreSqlRest.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/{employeeId}")
    public Employee getEmployeeDetail(@PathVariable("employeeId") String employeeId) {
        return employeeServices.getEmployee(employeeId);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeServices.getAllEmployees();
    }

    @PostMapping
    public String createEmployee(@RequestBody Employee employee) {
        employeeServices.createEmployee(employee);
        return "Employee created successfully!";
    }

    @PutMapping("/{employeeId}")
    public String updateEmployee(@PathVariable("employeeId") String employeeId,
                                 @RequestBody Employee employee) {
        employee.setEmployeeId(employeeId);
        employeeServices.updateEmployee(employee);
        return "Employee updated successfully!";
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") String employeeId) {
        employeeServices.deleteEmployee(employeeId);
        return "Employee deleted successfully!";
    }
}
