package com.recipe.dto;

import lombok.Data;

@Data
public class RecipeResponseDTO {
	
	private Long id;
	private String description;
	private String title;
	private String categoryName;
	private String username;

}
