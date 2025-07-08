package com.infosys.inventorysystem.repos;
import com.infosys.inventorysystem.beans.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface  ProductRepo extends JpaRepository<Products ,Integer> {
    List<Products> findByCategory(String category);
    List<Products> findByProductPriceBetween(double min, double max);
}
