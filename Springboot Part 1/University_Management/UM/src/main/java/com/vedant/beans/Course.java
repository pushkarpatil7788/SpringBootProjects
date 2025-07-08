package com.vedant.beans;

import org.springframework.stereotype.Component;

@Component
public class Course {
    private String title = "INFORMATION TECHNOLOGY";

    public String getCourse() {
        return title;
    }
    public void displayCourse(){
        System.out.println("Course: "+title);
    }
}