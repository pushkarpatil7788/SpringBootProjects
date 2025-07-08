package com.infosys.CoursePostgreSqlRest.controller;

import com.infosys.CoursePostgreSqlRest.model.Course;
import com.infosys.CoursePostgreSqlRest.model.CourseResponse;
import com.infosys.CoursePostgreSqlRest.services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/courses")
public class MyCourseController {

    private final CourseService courseService;

    @Autowired
    public MyCourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String myHome() {
        return "Welcome to Spring Boot Session";
    }

    @GetMapping("/welcome")
    public CourseResponse myWelcome() {
        CourseResponse response = new CourseResponse();
        response.setStatusCode(200);
        response.setStatusMsg("Enjoy Learning Spring Boot 3");
        response.setResponseDate(LocalDate.now());
        return response;
    }

    @PostMapping("/addcourse")
    public CourseResponse addCourse(@RequestBody Course course) {
        courseService.createCourse(course);
        CourseResponse response = new CourseResponse();
        response.setStatusCode(200);
        response.setStatusMsg("Course added successfully");
        response.setResponseDate(LocalDate.now());
        return response;
    }

    @PostMapping("/newcourse")
    public ResponseEntity<CourseResponse> addNewCourse(@RequestBody Course course) {
        courseService.createCourse(course);
        CourseResponse response = new CourseResponse();
        response.setStatusCode(200);
        response.setStatusMsg("Course added successfully");
        response.setResponseDate(LocalDate.now());
        HttpHeaders headers = new HttpHeaders();
        headers.add("My-Header", "RestPostgreApp");
        return new ResponseEntity<>(response, headers, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CourseResponse> deleteCourse(@PathVariable("id") String courseId) {
        courseService.deleteCourse(courseId);
        CourseResponse response = new CourseResponse();
        response.setStatusCode(200);
        response.setStatusMsg("Course deleted successfully!");
        response.setResponseDate(LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CourseResponse> updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
        CourseResponse response = new CourseResponse();
        response.setStatusCode(200);
        response.setStatusMsg("Course updated successfully!");
        response.setResponseDate(LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/allcourse")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/getcourse/{id}")
    public Course getCourseById(@PathVariable("id") String courseId) {
        return courseService.getCourse(courseId);
    }



}
