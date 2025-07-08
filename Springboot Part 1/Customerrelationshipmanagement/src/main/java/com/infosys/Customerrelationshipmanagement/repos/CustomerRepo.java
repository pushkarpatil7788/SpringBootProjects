package com.infosys.Customerrelationshipmanagement.repos;

import com.infosys.Customerrelationshipmanagement.beans.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customers,Integer> {

}
