package com.recipe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.dto.ReviewRequestDTO;
import com.recipe.dto.ReviewResponseDTO;
import com.recipe.model.Recipe;
import com.recipe.model.Review;
import com.recipe.model.User;
import com.recipe.repository.RecipeRepository;
import com.recipe.repository.ReviewRepository;
import com.recipe.repository.UserRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public ReviewResponseDTO addReview(ReviewRequestDTO request) {
		Review review=new Review();
		review.setRating(request.getRating());
		review.setComment(request.getComment());
		
		Recipe recipe=recipeRepository.findById(request.getRecipeId()).orElseThrow();
		review.setRecipe(recipe);
		User user=userRepository.findById(request.getUserId()).orElseThrow();
		review.setUser(user);
		
		reviewRepository.save(review);
		return mapToResponseDTO(review);
		
		
	}
	
	public List<ReviewResponseDTO> getAllReviews(){
		return reviewRepository.findAll().stream().map(this::mapToResponseDTO).collect(Collectors.toList());
	}
	public void deleteReview(Long id) {
		reviewRepository.deleteById(id);;
	}
	
	public ReviewResponseDTO updateReview(Long id,ReviewRequestDTO request) {
		Review existingReview=reviewRepository.findById(id).orElseThrow();
		existingReview.setRating(request.getRating());
		existingReview.setComment(request.getComment());
		Review updatedReview=reviewRepository.save(existingReview);
		return mapToResponseDTO(updatedReview);
		
	}
	
	private ReviewResponseDTO mapToResponseDTO(Review review) {
		ReviewResponseDTO dto=new ReviewResponseDTO();
		dto.setId(review.getId());
		dto.setComment(review.getComment());
		dto.setRating(review.getRating());
		dto.setRecipeTitle(review.getRecipe().getTitle());
		dto.setUsername(review.getUser().getUsername());
		
		
		return dto;
		
	}

}
