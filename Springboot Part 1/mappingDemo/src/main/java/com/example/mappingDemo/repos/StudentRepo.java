package com.example.mappingDemo.repos;

import com.example.mappingDemo.beans.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Students, Integer> {

    List<Students> findByDepartmentDeptId(int deptId);
}
