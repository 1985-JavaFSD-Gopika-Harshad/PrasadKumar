package com.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.CartDTO;
import com.store.model.Cart;
import com.store.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> addCartItem(@RequestBody CartDTO cartDTO) {
        Cart cart = cartService.addCartItem(cartDTO);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @PutMapping("/{cartId}/quantity")
    public ResponseEntity<Cart> updateCartItemQuantity(@PathVariable Long cartId, @RequestParam int quantity) {
        Cart updatedCart = cartService.updateCartItemQuantity(cartId, quantity);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long cartId) {
        cartService.removeCartItem(cartId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Cart>> getCartsByUserId(@PathVariable Long userId) {
        List<Cart> carts = cartService.getCartsByUserId(userId);
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/total")
    public ResponseEntity<Double> getTotalAmountByUserId(@PathVariable Long userId) {
        double totalAmount = cartService.calculateTotalAmountByUserId(userId);
        return new ResponseEntity<>(totalAmount, HttpStatus.OK);
    }
}