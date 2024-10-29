package com.recipe.dto;

import lombok.Data;

@Data
public class ReviewRequestDTO {
	
	private Integer rating;
    private String comment;
    private Long recipeId;
    private Long userId;

}
