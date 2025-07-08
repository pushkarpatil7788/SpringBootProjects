package com.infosys.CoursePostgreSqlRest.services;

import com.infosys.CoursePostgreSqlRest.model.Course;

import java.util.List;

public interface CourseServiceInterface {
    String createCourse(Course course);
    String updateCourse(Course course);
    String deleteCourse(String courseId);
    Course getCourse(String courseId);
    List<Course> getAllCourses();
}
