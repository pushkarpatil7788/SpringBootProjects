package com.infosys.jpaentitydemo.dao;

import com.infosys.jpaentitydemo.beans.Employees;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {

    public Employees addEmployee(Employees emp);
    public void findEmployee();
    Employees updateEmployee(int id, String name, String email);
    public void  removeEmployee(int empId);
    public List<Employees> findAllEmployees();
    public void findByEmail(String mailId);
    void validateEmployee(int empId, String empmail);

}
