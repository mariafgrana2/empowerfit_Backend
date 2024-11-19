package com.empowerfit.app.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.empowerfit.app.model.ProductProperty;
import com.empowerfit.app.repository.ProductPropertyRepository;
import com.empowerfit.app.service.ProductPropertyService;
@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

	ProductPropertyRepository productPropertyRepository;
	public ProductPropertyServiceImpl(ProductPropertyRepository productPropertyRepository) {
		this.productPropertyRepository = productPropertyRepository;
	}

	
	@Override
	public ProductProperty createProductProperty(ProductProperty productProperty) {
		//TODO Verificar si existe la propiedad de producto
		//TODO Verificar si los atributos son validos  
		ProductProperty newProductProperty = productPropertyRepository.save(productProperty);
		return newProductProperty;
	}

	@Override
	public ProductProperty getProductPropertyById(Long id) {
		Optional <ProductProperty> optionalProductProperty = productPropertyRepository.findById(id);
		if (optionalProductProperty.isEmpty()) {
			throw new IllegalStateException("Propiedad de producto inexistente");
		}
		ProductProperty existingProductProperty =optionalProductProperty.get();
		return existingProductProperty;
	}

	@Override
	public ProductProperty updateProductProperty(ProductProperty productProperty, Long id) {
		ProductProperty existingProductProperty = getProductPropertyById(id);
		existingProductProperty.setColors(productProperty.getColors());
		existingProductProperty.setProduct(productProperty.getProduct());
		existingProductProperty.setSizes(productProperty.getSizes());
		existingProductProperty.setVolumes(productProperty.getVolumes());
		return productPropertyRepository.save(existingProductProperty);
	}

	@Override
	public void deleteProductProperty(Long id) {
		ProductProperty existingProductProperty =getProductPropertyById(id);
		existingProductProperty.setActive(false);
		productPropertyRepository.save(existingProductProperty);
	}


	@Override
	public Set<ProductProperty> getAllProductProperties() {
		// TODO Auto-generated method stub
		return null;
	}
}
