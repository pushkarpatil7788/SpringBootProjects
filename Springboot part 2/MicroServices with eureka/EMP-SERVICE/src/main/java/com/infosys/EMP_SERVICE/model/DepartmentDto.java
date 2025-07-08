package com.infosys.EMP_SERVICE.model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto{
    private int deptId;
    private String departmentName;
    private int managerId;
}