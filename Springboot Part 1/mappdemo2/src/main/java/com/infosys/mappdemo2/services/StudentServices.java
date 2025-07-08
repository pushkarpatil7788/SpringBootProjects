package com.infosys.mappdemo2.services;

import com.infosys.mappdemo2.beans.Student;
import com.infosys.mappdemo2.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices implements StudentInterface{

    @Autowired
    StudentRepo studentRepo;

    @Override
    public void addStudent(Student student) {
        studentRepo.save(student);
    }
}
