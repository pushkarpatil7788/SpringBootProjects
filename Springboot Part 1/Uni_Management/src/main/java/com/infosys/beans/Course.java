package com.infosys.beans;

public class Course {
    private String courseName;
    private String instructor;

    public Course() {
    }

    public Course(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDetails() {
        return "Course: " + courseName + ", Instructor: " + instructor;
    }
}
