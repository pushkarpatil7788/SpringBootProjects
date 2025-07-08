package com.infosys.CoursePostgreSqlRest.services;

import com.infosys.CoursePostgreSqlRest.exception.CourseException;
import com.infosys.CoursePostgreSqlRest.model.Course;
import com.infosys.CoursePostgreSqlRest.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements CourseServiceInterface {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String createCourse(Course course) {
        courseRepo.save(course);
        return "Course created successfully!";
    }

    @Override
    public String updateCourse(Course course) {
        courseRepo.save(course);
        return "Course updated successfully!";
    }

    @Override
    public String deleteCourse(String courseId) {
        courseRepo.deleteById(courseId);
        return "Course deleted successfully!";
    }

    @Override
    public Course getCourse(String courseId) {
        return courseRepo.findById(courseId)
                .orElseThrow(() -> new CourseException("Course not found with ID: " + courseId));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }


}
