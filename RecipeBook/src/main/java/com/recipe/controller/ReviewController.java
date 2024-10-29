package com.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recipe.dto.ReviewRequestDTO;
import com.recipe.dto.ReviewResponseDTO;
import com.recipe.service.ReviewService;

@Controller
@RequestMapping("/api/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	
	@PostMapping
	public ReviewResponseDTO addReview(@RequestBody ReviewRequestDTO request) {
		return reviewService.addReview(request);
	}
	@GetMapping
	public List<ReviewResponseDTO> getAllReviews(){
		return reviewService.getAllReviews();
	}
	@DeleteMapping("/{id}")
	public String deleteReview(@PathVariable Long id) {
		reviewService.deleteReview(id);
		return "review is deleted successfully ";
	}
	@PutMapping("/{id}")
		public   ReviewResponseDTO updateReview(@PathVariable Long id,@RequestBody ReviewRequestDTO request) {
			return reviewService.updateReview(id, request);
		}
	}


