package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Category;
import com.vedant.Ecommerce.beans.Product;
import com.vedant.Ecommerce.repos.CategoryRepo;
import com.vedant.Ecommerce.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public Product assignCategoriesToProduct(int productId, List<Integer> categoryIds) {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product with ID " + productId + " not found.");
        }

        Product product = optionalProduct.get();

        List<Category> categories = categoryRepo.findAllById(categoryIds);
        if (categories.isEmpty()) {
            throw new RuntimeException("No categories found for provided IDs: " + categoryIds);
        }

        product.setCategories(new ArrayList<>(categories));
        return productRepo.save(product);
    }

    @Override
    public Product getProductById(int productId) {
        return productRepo.findById(productId).orElse(null);
    }
}
