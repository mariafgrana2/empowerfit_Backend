package com.empowerfit.app.repository;
import java.util.List;
import java.util.Optional;
import com.empowerfit.app.model.Product;

public interface ProductRepository {


	    // Busca todos los productos por nombre
	    List<Product> findByName(String name);

	    // Busca todos los productos que tengan la misma descripción
	    List<Product> findByDescription(String description);

	    // Busca los productos por precio
	    List<Product> findByPrice(Double price);

	    // Busca un producto específico por ID
	    Optional<Product> findById(Long id);

	    // Busca todos los productos que tengan una cantidad específica de stock
	    List<Product> findByStock(Integer stock);

	    // Busca todos los productos que tengan un número de piezas específico
	    List<Product> findByPieces(Integer pieces);

		List<Product> findAll();

		List<Product> findAll1();

}
