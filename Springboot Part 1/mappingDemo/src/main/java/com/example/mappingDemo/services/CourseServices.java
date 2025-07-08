package com.example.mappingDemo.services;

import com.example.mappingDemo.beans.Courses;
import com.example.mappingDemo.repos.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServices implements CourseServicesInterface {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public void saveCourse(Courses course) {
        courseRepo.save(course);
    }

    @Override
    public List<Courses> getAllCourses() {
        return courseRepo.findAll();
    }
}
