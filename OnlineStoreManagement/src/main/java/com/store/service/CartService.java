package com.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dto.CartDTO;
import com.store.model.Cart;
import com.store.model.Product;
import com.store.model.User;
import com.store.repository.CartRepository;




@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserService userService;

    public Cart addCartItem(CartDTO cartDTO) {
    	User user=userService.getUserById(cartDTO.getUserID());
    	Product product=productService.getProductById(cartDTO.getProductID());
        Cart cart = Cart.builder()
                .user(user)
                .product(product)
                .quantity(cartDTO.getQuantity())
                .price(product.getPrice())
                .totalAmount(cartDTO.getQuantity() * product.getPrice()) 
                .build();
        return cartRepository.save(cart);
    }

    public Cart updateCartItemQuantity(Long cartId, int quantity) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cart.setQuantity(quantity);
        cart.setTotalAmount(quantity * cart.getPrice()); // Update total amount
        return cartRepository.save(cart);
    }

    public void removeCartItem(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartRepository.delete(cart);
    }

    public List<Cart> getCartsByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public double calculateTotalAmountByUserId(Long userId) {
        List<Cart> carts = cartRepository.findByUserId(userId);
        return carts.stream()
                .mapToDouble(cart -> cart.getPrice() * cart.getQuantity())
                .sum();
    }
}
