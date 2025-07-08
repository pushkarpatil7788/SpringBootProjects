package com.infosys.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    private int id = 101;
    private String name = "Pushkar Patil";
    private String designation = "Software Engineer";
    private double salary = 85000.0;

    @Autowired
    private Address address;

    public void displayEmployeeDetails() {
        System.out.println("Employee Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: ₹" + salary);
        System.out.println("Address: " + address.getFullAddress());
    }
}
