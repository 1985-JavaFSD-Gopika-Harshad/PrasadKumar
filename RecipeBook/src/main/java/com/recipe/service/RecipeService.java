package com.recipe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.dto.RecipeRequestDTO;
import com.recipe.dto.RecipeResponseDTO;
import com.recipe.model.Category;
import com.recipe.model.Recipe;
import com.recipe.model.User;
import com.recipe.repository.CategoryRepository;
import com.recipe.repository.RecipeRepository;
import com.recipe.repository.UserRepository;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public RecipeResponseDTO createRecipe(RecipeRequestDTO request) {
		Recipe recipe=new Recipe();
		recipe.setTitle(request.getTitle());
		recipe.setDescription(request.getDescription());
		
		Category category=categoryRepository.findById(request.getCategoryId()).orElseThrow();
		User user=userRepository.findById(request.getUserId()).orElseThrow();
		
		recipe.setCategory(category);
		recipe.setUser(user);
		
		recipeRepository.save(recipe);
		return mapToResponse(recipe) ;
		
	}
	public List<RecipeResponseDTO> getAllRecipes(){
		return recipeRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
	}
	
	public void deleteRecipe(Long id) {
		recipeRepository.deleteById(id);
	}
	
	private RecipeResponseDTO mapToResponse(Recipe recipe) {
		RecipeResponseDTO dto=new RecipeResponseDTO();
		dto.setId(recipe.getId());
		dto.setTitle(recipe.getTitle());
		dto.setDescription(recipe.getDescription());
		dto.setCategoryName(recipe.getCategory().getName());
		dto.setUsername(recipe.getUser().getUsername());
		return dto;
		
	}

}
