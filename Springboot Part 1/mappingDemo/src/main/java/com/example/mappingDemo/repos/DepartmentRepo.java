package com.example.mappingDemo.repos;

import com.example.mappingDemo.beans.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Departments, Integer> {

}
