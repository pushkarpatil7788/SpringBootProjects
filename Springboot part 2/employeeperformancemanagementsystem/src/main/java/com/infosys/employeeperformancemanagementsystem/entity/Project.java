package com.infosys.employeeperformancemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int durationMonths;

    @ManyToMany(mappedBy = "projects",fetch = FetchType.EAGER)
    private Set<Employee> employees;
}
