package com.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.model.Category;

public interface CategoryRepository extends JpaRepository<Category ,Long>{

}
