package com.infosys.EcommerceSystem.repos;

import com.infosys.EcommerceSystem.beans.Category;
import com.infosys.EcommerceSystem.beans.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
