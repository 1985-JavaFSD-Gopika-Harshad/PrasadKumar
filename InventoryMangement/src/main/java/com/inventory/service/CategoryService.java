package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.CategoryRequest;
import com.inventory.model.Category;
import com.inventory.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(CategoryRequest categoryRequest) {
        Category category = Category.builder()
        		.name(categoryRequest.getName())
        		.build();
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow();
    }

    public Category updateCategory(Long id, CategoryRequest categoryRequest) {
        Category category = getCategoryById(id);
        category.setName(categoryRequest.getName());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        Category category = getCategoryById(id);
        categoryRepository.delete(category);
    }
}

