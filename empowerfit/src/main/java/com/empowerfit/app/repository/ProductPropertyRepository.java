package com.empowerfit.app.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.ProductProperty;

public interface ProductPropertyRepository extends CrudRepository<ProductProperty, Long> {

    // SELECT * FROM product_property WHERE material = ?
    List<ProductProperty> findByMaterial(String material);

    // SELECT * FROM product_property WHERE id = ?
    ProductProperty findById(long id);

    // Obtiene todas las propiedades con un material específico
    Set<ProductProperty> findAllByMaterial(String material);
}
