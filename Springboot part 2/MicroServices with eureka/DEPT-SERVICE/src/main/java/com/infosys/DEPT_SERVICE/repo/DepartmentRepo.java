package com.infosys.DEPT_SERVICE.repo;

import com.infosys.DEPT_SERVICE.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
