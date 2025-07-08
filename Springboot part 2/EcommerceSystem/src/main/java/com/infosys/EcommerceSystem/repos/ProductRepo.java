package com.infosys.EcommerceSystem.repos;

import com.infosys.EcommerceSystem.beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
