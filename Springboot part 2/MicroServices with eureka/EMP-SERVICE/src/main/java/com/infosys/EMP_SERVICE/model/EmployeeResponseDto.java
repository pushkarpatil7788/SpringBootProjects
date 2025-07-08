package com.infosys.EMP_SERVICE.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {
    private int empId;
    private String name;
    private int deptId;
    private double salary;
    private String deptName;
    private int managerId;
}