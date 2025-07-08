package com.example.mappingDemo.services;

import com.example.mappingDemo.beans.Students;
import com.example.mappingDemo.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices implements StudentInterface {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void saveStudent(Students student) {
        studentRepo.save(student);
    }
}
