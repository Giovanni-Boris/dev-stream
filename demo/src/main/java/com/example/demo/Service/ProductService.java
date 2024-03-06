package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
}