package com.example.mappingDemo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;

    @NotBlank(message = "deptname can not be empty")
    private String deptName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Students> studentList;

    public Departments() {
    }

    public Departments(String deptName) {
        this.deptName = deptName;
    }

    // Getters and Setters

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Students> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Students> studentList) {
        this.studentList = studentList;
    }
}
