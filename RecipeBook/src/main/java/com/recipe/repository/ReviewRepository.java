package com.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
