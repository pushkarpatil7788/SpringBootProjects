package com.infosys.employeeperformancemanagementsystem.repository;


import com.infosys.employeeperformancemanagementsystem.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Integer> {
}
