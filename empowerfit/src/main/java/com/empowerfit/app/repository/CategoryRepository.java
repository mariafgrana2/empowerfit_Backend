package com.empowerfit.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>  {
	// Busca todas las categorías por nombre
    List<Category> findByName(String name);

    // Busca una categoría específica por ID
    Category findById(long id);

    // Devuelve todas las categorías
    List<Category> findAll();
}
