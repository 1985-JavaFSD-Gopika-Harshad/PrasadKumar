package com.recipe.dto;

import lombok.Data;

@Data
public class RecipeRequestDTO {
	
	private String title;
	private String description;
	private Long categoryId;
	private Long userId;
	

}
