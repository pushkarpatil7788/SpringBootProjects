package com.vedant.beans;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name = "Vedant";

    public String getName() {
        return name;
    }

    public void displayStudent() {
        System.out.println("Student: " + name);
    }
}