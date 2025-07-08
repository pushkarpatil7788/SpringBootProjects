package com.infosys.Admin_REST.controller;


import com.infosys.Admin_REST.model.AdminResponce;
import com.infosys.Admin_REST.model.Course;
import com.infosys.Admin_REST.proxy.Adminproxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Adminservice")
public class AdminController {

    @Autowired
    private Adminproxy adminproxy;

    @GetMapping("/admin")
    public ResponseEntity<AdminResponce> adminHome() {
        AdminResponce response = new AdminResponce();
        response.setHttpStatusCode(HttpStatus.OK);
        response.setHttpMessage("Hello From Admin Service");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
    @GetMapping("/getCourseList")
    public List<Course> getCourseList() {
        return adminproxy.getAllCourse();
    }
}
