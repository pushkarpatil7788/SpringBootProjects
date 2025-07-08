package com.infosys.mappdemo2.beans;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseNmae;

    @ManyToMany
    private List<Student> enrolleedStudentList;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseNmae() {
        return courseNmae;
    }

    public void setCourseNmae(String courseNmae) {
        this.courseNmae = courseNmae;
    }

    public List<Student> getEnrolleedStudentList() {
        return enrolleedStudentList;
    }

    public void setEnrolleedStudentList(List<Student> enrolleedStudentList) {
        this.enrolleedStudentList = enrolleedStudentList;
    }


}
