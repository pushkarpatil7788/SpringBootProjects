package com.infosys.Department_Rest.Controller;

import com.infosys.Department_Rest.model.Departments;
import com.infosys.Department_Rest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Departments> SaveDepartment(@RequestBody Departments department)
    {
        Departments savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDepartmentById(@PathVariable("id") Long departmentid)
    {
        Departments Department = departmentService.getDepartmentById(departmentid);
        return new ResponseEntity<>(Department, HttpStatus.OK);
    }



}
