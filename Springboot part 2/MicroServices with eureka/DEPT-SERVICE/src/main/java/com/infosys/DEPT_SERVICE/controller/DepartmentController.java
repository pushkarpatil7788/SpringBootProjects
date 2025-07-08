package com.infosys.DEPT_SERVICE.controller;

import com.infosys.DEPT_SERVICE.model.Department;
import com.infosys.DEPT_SERVICE.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepo repo;


    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        return repo.save(department);
    }


    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        return repo.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
