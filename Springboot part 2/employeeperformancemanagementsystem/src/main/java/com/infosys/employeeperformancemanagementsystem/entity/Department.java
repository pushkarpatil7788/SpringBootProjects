package com.infosys.employeeperformancemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DepartmentId;
    private String DepartmentName;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

}