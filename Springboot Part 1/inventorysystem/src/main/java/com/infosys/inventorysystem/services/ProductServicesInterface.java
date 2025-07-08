package com.infosys.inventorysystem.services;
import com.infosys.inventorysystem.beans.Products;
import java.util.List;
import java.util.Optional;

public interface ProductServicesInterface {
    void addProducts(Products product);
    void addMultipleProducts(List<Products> ProductsList);
    Optional<Products> findProductById(int ProductId);
    void updateProduct(Products product);  // Add this line
    void deleteProduct(int ProductId);
    List<Products> getAllProducts();
}
