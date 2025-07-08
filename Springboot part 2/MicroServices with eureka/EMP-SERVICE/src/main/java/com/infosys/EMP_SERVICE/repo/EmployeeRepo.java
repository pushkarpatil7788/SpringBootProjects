package com.infosys.EMP_SERVICE.repo;

import com.infosys.EMP_SERVICE.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
