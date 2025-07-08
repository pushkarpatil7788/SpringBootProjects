package com.infosys.springbootDemo.repos;

import com.infosys.springbootDemo.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    Student findByEmail(@Param("email") String studentMail);
}
