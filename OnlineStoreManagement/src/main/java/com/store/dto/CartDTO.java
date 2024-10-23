package com.store.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
	private Long userID;
	private Long productID;
	private int quantity;
	private double price;

}
