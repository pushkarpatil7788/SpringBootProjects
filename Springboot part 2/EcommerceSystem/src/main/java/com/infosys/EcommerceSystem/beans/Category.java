package com.infosys.EcommerceSystem.beans;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String categoryName;

    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    @Override
    public String toString() {
        return "Category{id=" + categoryId + ", name='" + categoryName + "'}";
    }
}