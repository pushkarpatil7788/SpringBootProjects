package com.infosys.EcommerceSystem.services;

import com.infosys.EcommerceSystem.beans.Product;
import com.infosys.EcommerceSystem.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public void addProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(int productId) {
        return productRepo.findById(productId).orElse(null);
    }

    @Override
    public void updateProduct(int productId, Product updatedProduct) {
        Product existing = productRepo.findById(productId).orElse(null);
        if (existing != null) {
            existing.setProductName(updatedProduct.getProductName());
            existing.setProductPrice(updatedProduct.getProductPrice());
            existing.setCategories(updatedProduct.getCategories());
            productRepo.save(existing);
        }
    }

    @Override
    public void deleteProduct(int productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public void saveProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product getProductWithCategories(int productId) {
        return productRepo.findById(productId).orElse(null);
    }


}
