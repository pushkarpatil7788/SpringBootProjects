package com.infosys.demo_admin.proxy;

import com.infosys.demo_admin.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8083/courses", value = "course")
public interface AdminProxy {

    @GetMapping("/allcourse")
    List<Course> getAllCourse();

    @GetMapping("/getcourse/{id}")
    Course getCourseById(@PathVariable("id") String courseId);
}