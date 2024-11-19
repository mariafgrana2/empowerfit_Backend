package com.empowerfit.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.empowerfit.app.model.Category;
import com.empowerfit.app.repository.CategoryRepository;
import com.empowerfit.app.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        category.setId(null); // Asegurar que es una nueva categoría
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategoriesByName(String name) {
        List<Category> categories = categoryRepository.findByName(name);
        if (categories.isEmpty()) {
            throw new IllegalStateException("No existen categorías con el nombre: " + name);
        }
        return categories;
    }

    @Override
    public Category getCategoryById(long id) {
        return Optional.ofNullable(categoryRepository.findById(id))
                .orElseThrow(() -> new IllegalStateException("No existe la categoría con ID: " + id));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category, long id) {
        Category existingCategory = getCategoryById(id);
        existingCategory.setDescription(category.getDescription());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(long id) {
        Category existingCategory = getCategoryById(id);
        categoryRepository.delete(existingCategory);
    }
}

