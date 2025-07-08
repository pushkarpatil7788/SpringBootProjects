package com.infosys.CoursePostgreSqlRest.repo;

import com.infosys.CoursePostgreSqlRest.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, String> {
}
