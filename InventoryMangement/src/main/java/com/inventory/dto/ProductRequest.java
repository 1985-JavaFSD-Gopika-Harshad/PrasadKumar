package com.inventory.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
	private String name;
    private String description;
    private double price;
    private int quantity;
    private Long category;
    private Long supplier;
}
