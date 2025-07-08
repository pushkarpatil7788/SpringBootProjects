package com.example.mappingDemo.services;

import com.example.mappingDemo.beans.Courses;
import java.util.List;

public interface CourseServicesInterface {
    void saveCourse(Courses course);
    List<Courses> getAllCourses();
}
