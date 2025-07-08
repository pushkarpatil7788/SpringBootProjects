package com.infosys.springbootDemo.services;

import com.infosys.springbootDemo.beans.Student;
import com.infosys.springbootDemo.repos.LaptopRepo;
import com.infosys.springbootDemo.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices implements StudentServicesInterfaces{

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    LaptopRepo laptopRepo;

    @Override
    public void addStudent(Student student) {
        studentRepo.save(student);
    }
}
