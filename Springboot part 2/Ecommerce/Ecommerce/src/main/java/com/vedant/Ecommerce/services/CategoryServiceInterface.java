package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Category;

import java.util.List;

public interface CategoryServiceInterface {
    Category saveCategory(Category category);
    Category getCategoryById(int id);
    List<Category> getAllCategories();
}
