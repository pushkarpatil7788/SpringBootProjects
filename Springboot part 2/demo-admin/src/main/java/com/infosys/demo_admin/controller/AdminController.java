package com.infosys.demo_admin.controller;


import com.infosys.demo_admin.model.AdminResponce;
import com.infosys.demo_admin.model.Course;
import com.infosys.demo_admin.proxy.AdminProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adminServices")
public class AdminController {

    @Autowired
    AdminProxy adminProxy;


    @GetMapping("/admin")
    public ResponseEntity<AdminResponce> adminHome(){
        AdminResponce responce=new AdminResponce();
        responce.setHttpStatusCode(HttpStatus.OK);
        responce.setHttpMessage("hello from Admin Service");
        return ResponseEntity.status(HttpStatus.OK).body(responce);
    }

    @GetMapping("/getCourseslist")
    public List<Course> getAllCourse(){
        return adminProxy.getAllCourse();
    }

    @GetMapping("/getcourse/{id}")
    public Course getCourseById(@PathVariable("id") String courseId) {
        return adminProxy.getCourseById(courseId);
    }


}
