package com.infosys.EcommerceSystem.repos;

import com.infosys.EcommerceSystem.beans.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
