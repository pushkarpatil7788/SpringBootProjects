package com.infosys.springbootDemo.repos;

import com.infosys.springbootDemo.beans.Laptops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository <Laptops , Integer> {

}
