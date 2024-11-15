package com.empowerfit.app.service;

import java.util.Set;

import com.empowerfit.app.model.ProductProperty;


public interface ProductPropertyService {


    ProductProperty createProductProperty(ProductProperty productProperty);
    ProductProperty getProductPropertyById(Long id);
    Set<ProductProperty> getAllProductProperties();
    ProductProperty updateProductProperty(ProductProperty productProperty, Long id);
    void deleteProductProperty(Long id);
}
