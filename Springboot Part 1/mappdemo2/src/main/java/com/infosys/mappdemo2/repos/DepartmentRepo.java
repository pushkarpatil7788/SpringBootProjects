package com.infosys.mappdemo2.repos;

import com.infosys.mappdemo2.beans.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {

}
