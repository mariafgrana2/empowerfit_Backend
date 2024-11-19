package com.empowerfit.app.service;

import com.empowerfit.app.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product createProduct(Product product);
    
    Optional<Product> getProductById(Long id);
    List<Product> getProductsByName(String name);
    
    List<Product> getProductsUnderPrice(Double maxPrice);
    List<Product> getProductsAbovePrice(Double minPrice);

    List<Product> getAvailableProducts();
    List<Product> getAllProducts();
    
    Product updateProduct(Product product, Long id);
    void deleteProduct(Long id);
}
