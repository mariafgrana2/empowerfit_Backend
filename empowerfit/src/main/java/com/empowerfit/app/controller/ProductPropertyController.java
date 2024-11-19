package com.empowerfit.app.controller;

import com.empowerfit.app.model.ProductProperty;
import com.empowerfit.app.service.ProductPropertyService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/product-properties") // Ruta 
public class ProductPropertyController {

    private final ProductPropertyService productPropertyService;

    public ProductPropertyController(ProductPropertyService productPropertyService) {
        this.productPropertyService = productPropertyService;
    }

    @PostMapping
    public ResponseEntity<ProductProperty> createProductProperty(@RequestBody ProductProperty newProductProperty) {
        ProductProperty createdProductProperty = productPropertyService.createProductProperty(newProductProperty);
        return ResponseEntity.status(201).body(createdProductProperty);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductProperty> getProductPropertyById(@PathVariable Long id) {
        ProductProperty productProperty = productPropertyService.getProductPropertyById(id);
        return ResponseEntity.ok(productProperty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductProperty> updateProductProperty(
            @PathVariable Long id, 
            @RequestBody ProductProperty updatedProductProperty) {
        ProductProperty productProperty = productPropertyService.updateProductProperty(updatedProductProperty, id);
        return ResponseEntity.ok(productProperty);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductProperty(@PathVariable Long id) {
        productPropertyService.deleteProductProperty(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Set<ProductProperty>> getAllProductProperties() {
        Set<ProductProperty> productProperties = productPropertyService.getAllProductProperties();
        return ResponseEntity.ok(productProperties);
    }
}
