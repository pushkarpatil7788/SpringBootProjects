package com.infosys.EcommerceSystem.services;

import com.infosys.EcommerceSystem.beans.Category;
import com.infosys.EcommerceSystem.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CactrgoryService implements CactrgoryServiceInterface {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryRepo.findById(categoryId).orElse(null);
    }

    @Override
    public void updateCategory(int categoryId, Category updatedCategory) {
        Category existing = categoryRepo.findById(categoryId).orElse(null);
        if (existing != null) {
            existing.setCategoryName(updatedCategory.getCategoryName());
            categoryRepo.save(existing);
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryRepo.deleteById(categoryId);
    }

    @Override
    public Category getCategoryWithProducts(int categoryId) {
        return categoryRepo.findById(categoryId).orElse(null);
    }

}
