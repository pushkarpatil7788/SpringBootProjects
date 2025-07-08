package com.infosys.service;

import com.infosys.beans.Student;
import com.infosys.beans.Course;

public class UniversityService {
    private Student student;
    private Course course;

    // Setter injection
    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void enrollStudent() {
        System.out.println(student.getDetails() + " has been enrolled in " + course.getDetails());
    }
}
