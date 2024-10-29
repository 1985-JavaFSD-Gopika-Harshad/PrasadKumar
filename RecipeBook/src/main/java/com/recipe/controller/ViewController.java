package com.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.recipe.dto.RecipeResponseDTO;
import com.recipe.service.RecipeService;


@Controller
public class ViewController {
	 @Autowired
	    private RecipeService recipeService;

	    @GetMapping("/recipes")
	    public String index(Model model) {
	        List<RecipeResponseDTO> recipes = recipeService.getAllRecipes();
	        model.addAttribute("recipes", recipes);
	        return "recipeList"; 
	    }
	    @GetMapping("/add")
	    public String addRecipe() {
	    	return "recipeForm";
	    }
	    
}
