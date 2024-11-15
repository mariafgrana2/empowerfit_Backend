package com.empowerfit.app.service;

import java.util.List;
import com.empowerfit.app.model.Category;

public interface CategoryService {

	// Crea una nueva categoría.
    Category createCategory(Category category);

    //Busca todas las categorías que coincidan con un nombre específico.
    List<Category> getCategoriesByName(String name);

    //Obtiene una categoría específica por su ID.
    Category getCategoryById(long id);

    // Devuelve todas las categorías registradas.
    List<Category> getAllCategories();

    // Actualiza una categoría existente.
    Category updateCategory(Category category, long id);

    // Elimina una categoría por su ID.
     
    void deleteCategory(long id);
}