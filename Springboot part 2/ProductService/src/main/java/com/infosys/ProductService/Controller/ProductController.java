package com.infosys.ProductService.Controller;

import com.infosys.ProductService.model.Product;
import com.infosys.ProductService.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;


    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }


    @GetMapping("/allproducts")
    public List<Product> displayAllProducts() {
        return productRepo.findAll();
    }


    @GetMapping("/{productId}")
    public ResponseEntity<Product> displayProductById(@PathVariable int productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
        return ResponseEntity.ok(product);
    }
}
