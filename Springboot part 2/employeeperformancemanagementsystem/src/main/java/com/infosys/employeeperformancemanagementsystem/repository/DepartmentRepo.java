package com.infosys.employeeperformancemanagementsystem.repository;

import com.infosys.employeeperformancemanagementsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {

}
