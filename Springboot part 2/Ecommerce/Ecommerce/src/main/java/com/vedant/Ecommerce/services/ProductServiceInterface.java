package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Product;

import java.util.List;

public interface ProductServiceInterface {
    Product assignCategoriesToProduct(int productId, List<Integer> categoryIds);
    Product getProductById(int productId);
}
