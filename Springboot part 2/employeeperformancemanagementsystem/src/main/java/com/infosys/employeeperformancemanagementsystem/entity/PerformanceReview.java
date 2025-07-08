package com.infosys.employeeperformancemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rating;
    private String remarks;
    private LocalDate reviewDate;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
