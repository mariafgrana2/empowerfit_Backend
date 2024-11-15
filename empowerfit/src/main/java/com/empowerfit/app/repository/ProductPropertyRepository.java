package com.empowerfit.app.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.ProductProperty;

public interface ProductPropertyRepository extends CrudRepository<ProductProperty, Long> {

    // SELECT * FROM product_property WHERE material = ?
    List<ProductProperty> findByMaterial(String material);

    // SELECT * FROM product_property WHERE size_id = ?
    List<ProductProperty> findBySizeId(Long sizeId);

    // SELECT * FROM product_property WHERE id = ?
    Optional<ProductProperty> findById(Long id);

    // Obtiene todas las propiedades con un material específico
    Set<ProductProperty> findAllByMaterial(String material);
}
