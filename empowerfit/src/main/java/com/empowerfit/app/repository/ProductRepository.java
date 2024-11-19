package com.empowerfit.app.repository;

import com.empowerfit.app.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByName(String name);
   
    Optional<Product> findById(Long id);
     
    List<Product> findAllByStockGreaterThan(Integer stock);

    List<Product> findAllByPriceLessThanEqual(Double price);

    List<Product> findAllByPriceGreaterThan(Double price);
}
