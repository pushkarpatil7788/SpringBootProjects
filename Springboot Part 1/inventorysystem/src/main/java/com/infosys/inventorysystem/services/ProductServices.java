package com.infosys.inventorysystem.services;
import com.infosys.inventorysystem.beans.Products;
import com.infosys.inventorysystem.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServices implements ProductServicesInterface{
    @Autowired
    ProductRepo productRepo;
    @Override
    public void addProducts(Products product){
    productRepo.save(product);
    }
    @Override
    public void addMultipleProducts(List<Products> ProductsList) {
        Iterable<Products> procustInfo =  productRepo.saveAll(ProductsList);
    }
    @Override
    public Optional<Products> findProductById(int productId) {
        return productRepo.findById(productId);
    }
    @Override
    public void updateProduct(Products products) {
        productRepo.save(products);
    }
    @Override
    public void deleteProduct(int ProductId) {
        productRepo.deleteById(ProductId);
    }
    @Override
    public List<Products> getAllProducts() {
        return productRepo.findAll();
    }
    public List<Products> getProductsByCategory(String category) {
        return productRepo.findByCategory(category);
    }
    public List<Products> getProductsByPriceRange(double min, double max) {
        return productRepo.findByProductPriceBetween(min, max);
    }
}
