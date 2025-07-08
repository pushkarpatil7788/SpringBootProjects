package com.infosys.beans;

public class Student {
    private String name;
    private int rollNumber;

    public Student() {
    }

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getDetails() {
        return "Student: " + name + ", Roll No: " + rollNumber;
    }
}
