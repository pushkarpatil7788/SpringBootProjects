package com.infosys.employeemanagement2.services;
import com.infosys.employeemanagement2.beans.Employees;
import com.infosys.employeemanagement2.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices implements EmployeeServicesInterface{
    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public void addEmployees(Employees employee){
        employeeRepo.save(employee);
    }
    @Override
    public Optional<Employees> findEmployeeById(int employeeId) {
        return employeeRepo.findById(employeeId);
    }
    @Override
    public void updateEmployee(Employees employee) {
        employeeRepo.save(employee);
    }
    @Override
    public void deleteEmployee(int EmployeeId) {
        employeeRepo.deleteById(EmployeeId);
    }
    public List<Employees> getEmployeesByDepartment(String department) {
        return employeeRepo.findByEmpDepartment(department);
    }

    public List<Employees> getEmployeesByRole(String role) {
        return employeeRepo.findByEmpRole(role);
    }

    public List<Employees> getEmployeesByLocation(String location) {
        return employeeRepo.findByEmpLocation(location);
    }

}
