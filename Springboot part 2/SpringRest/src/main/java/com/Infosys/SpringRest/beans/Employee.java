package com.Infosys.SpringRest.beans;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
        private String empId;
        private String empName;
        private String empDept;
        private double empSalary;

        public Employee() {
        }
}
