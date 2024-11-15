
package com.empowerfit.app.repository;

import java.util.List;
import java.util.Optional;
import com.empowerfit.app.model.Category;

public interface CategoryService {

    // Busca todas las categorías por nombre
    List<Category> findByName(String name);

    // Busca todas las categorías que tengan la misma descripción
    List<Category> findByDescription(String description);

    // Busca una categoría específica por ID
    Category findById(long id);

    // Devuelve todas las categorías
    List<Category> findAll();

    // Devuelve todas las categorías activas
    List<Category> findAllActiveCategories();
}