package com.example.mappingDemo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @NotBlank(message = "student name can't be empty")
    private String studentName;

    @Email(message = "please enter a valid email")
    private String studentEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Departments department;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Courses> coursesList;

    // Setter
    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
        for (Courses course : coursesList) {
            course.setStudent(this); // Set back-reference
        }
    }

    // Getter
    public List<Courses> getCoursesList() {
        return coursesList;
    }


    public Students() {
    }

    // Constructor for just name and email
    public Students(String studentName, String studentEmail) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
    }

    // Constructor with all fields
    public Students(String studentName, String studentEmail, Departments department) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.department = department;
    }

    // Getters and Setters

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }
}
