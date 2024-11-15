package com.empowerfit.app.repository;

import java.util.List;

import com.empowerfit.app.model.Category;

public interface CategoryRepository {
	// Busca todas las categorías por nombre
    List<Category> findByName(String name);

    // Busca una categoría específica por ID
    Category findById(long id);

    // Devuelve todas las categorías
    List<Category> findAll();
}
