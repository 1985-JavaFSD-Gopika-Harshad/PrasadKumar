package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.Products;

public interface ProductRepository extends JpaRepository<Products,Long> {

}
