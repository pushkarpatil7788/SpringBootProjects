package com.example.mappingDemo.repos;

import com.example.mappingDemo.beans.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Courses, Integer> {
}
