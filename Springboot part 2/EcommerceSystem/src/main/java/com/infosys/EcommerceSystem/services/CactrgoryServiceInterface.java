package com.infosys.EcommerceSystem.services;

import com.infosys.EcommerceSystem.beans.Category;
import java.util.List;

public interface CactrgoryServiceInterface {
    void addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(int categoryId);
    void updateCategory(int categoryId, Category updatedCategory);
    void deleteCategory(int categoryId);
    Category getCategoryWithProducts(int categoryId);

}
