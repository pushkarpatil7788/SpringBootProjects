package com.infosys.EcommerceSystem.services;

import com.infosys.EcommerceSystem.beans.Product;
import java.util.List;

public interface ProductServiceInterface {
    void addProduct(Product product);
    void saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int productId);
    void updateProduct(int productId, Product updatedProduct);
    void deleteProduct(int productId);
    Product getProductWithCategories(int productId);

}
