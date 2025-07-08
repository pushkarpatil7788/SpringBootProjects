package com.infosys.PostgreSqlRest.repos;

import com.infosys.PostgreSqlRest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,String> {

}
