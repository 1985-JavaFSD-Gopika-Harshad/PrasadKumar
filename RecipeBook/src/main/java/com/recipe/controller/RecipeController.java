package com.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recipe.dto.RecipeRequestDTO;
import com.recipe.dto.RecipeResponseDTO;
import com.recipe.service.RecipeService;

@Controller
@RequestMapping("/api/recipes")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@PostMapping("/add")
	 public String createRecipe(RecipeRequestDTO request) {
		recipeService.createRecipe(request);
		return "redirect:/recipes";
		
	}
	@GetMapping("/list")
    public String getAllRecipes(Model model) {
        List<RecipeResponseDTO> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "recipeList"; // JSP page name
    }
	@DeleteMapping("/{id}")
	public  String deleteRecipe(@PathVariable Long id) {
		recipeService.deleteRecipe(id);
		return "recipe is deleted successfully with id :"+id;
	}
}
