package com.infosys.Department_Rest.repository;

import com.infosys.Department_Rest.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository <Departments, Long> {
}
