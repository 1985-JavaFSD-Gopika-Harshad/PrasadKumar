package com.recipe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.dto.CategoryDTO;
import com.recipe.model.Category;
import com.recipe.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryDTO createCategory(CategoryDTO request) {
		Category category=new Category();
		category.setName(request.getName());
		categoryRepository.save(category);
		
		return mapToDTO(category);
		
	}
	public List<CategoryDTO> getAllCategories(){
		return categoryRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
	
	private CategoryDTO mapToDTO(Category category) {
		CategoryDTO dto=new CategoryDTO();
		dto.setId(category.getId());
		dto.setName(category.getName());
		return dto;
	}

}
