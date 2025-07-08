package com.infosys.User_Rest.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private Long id;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
