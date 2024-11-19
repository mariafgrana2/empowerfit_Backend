package com.empowerfit.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.empowerfit.app.model.Product;
import com.empowerfit.app.repository.ProductRepository;
import com.empowerfit.app.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        product.setId(null); // Aseguramos que sea un nuevo producto
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        List<Product> products = productRepository.findByName(name);
        if (products.isEmpty()) {
            throw new IllegalStateException("No existen productos con el nombre: " + name);
        }
        return products;
    }

    @Override
    public List<Product> getProductsUnderPrice(Double maxPrice) {
        return productRepository.findAllByPriceLessThanEqual(maxPrice);
    }

    @Override
    public List<Product> getProductsAbovePrice(Double minPrice) {
        return productRepository.findAllByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> getAvailableProducts() {
        return productRepository.findAllByStockGreaterThan(0);
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Product existingProduct = getProductById(id)
                .orElseThrow(() -> new IllegalStateException("El producto con ID " + id + " no existe."));
        
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setImageUrl(product.getImageUrl());
        existingProduct.setStock(product.getStock());
        existingProduct.setPieces(product.getPieces());
        existingProduct.setCategory(product.getCategory());

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = getProductById(id)
                .orElseThrow(() -> new IllegalStateException("El producto con ID " + id + " no existe."));
        productRepository.delete(product);
    }
}
