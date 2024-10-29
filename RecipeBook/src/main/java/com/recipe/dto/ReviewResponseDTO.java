package com.recipe.dto;

import lombok.Data;

@Data
public class ReviewResponseDTO {
	
	private Long id;
    private Integer rating;
    private String comment;
    private String recipeTitle;
    private String username;

}
