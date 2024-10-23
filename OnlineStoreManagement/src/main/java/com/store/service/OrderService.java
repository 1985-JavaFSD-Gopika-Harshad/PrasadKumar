package com.store.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dto.OrderDTO;
import com.store.dto.OrderItemDTO;
import com.store.model.Cart;
import com.store.model.Order;
import com.store.model.OrderItem;
import com.store.model.Status;
import com.store.model.User;
import com.store.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService; 
    
    @Autowired
    private UserService userService;
    public String placeOrder(OrderDTO orderDTO) {
        List<Cart> cartItems = cartService.getCartsByUserId(orderDTO.getUserId());
    	User user=userService.getUserById(orderDTO.getUserId());
 
        if (cartItems.isEmpty()) {
            return "Cart is empty. Cannot place order.";
        }

        double totalAmount = cartItems.stream()
            .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
            .sum();

        Order order = Order.builder()
                .user(user) 
                .orderDate(LocalDate.now())
                .address(orderDTO.getAddress())
                .totalAmount(totalAmount)
                .status(Status.Placed)
                .build();

        orderRepository.save(order);

        List<OrderItem> orderItems = new ArrayList<>();
        for (Cart cartItem : cartItems) {
            OrderItem orderItem = OrderItem.builder()
                    .product(cartItem.getProduct()) 
                    .quantity(cartItem.getQuantity())
                    .order(order) 
                    .build();
            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems); 
        orderRepository.save(order); 

        return "Order placed successfully!";
    }
    public List<OrderItemDTO> getOrderItems(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return order.getOrderItems().stream().map(orderItem -> {
            return OrderItemDTO.builder()
                    .productId(orderItem.getProduct().getId())
                    .quantity(orderItem.getQuantity())
                    .orderId(order.getId())
                    .build();
        }).collect(Collectors.toList());
    }

    public Order updateOrderStatus(Long orderId, Status status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status); 
        return orderRepository.save(order); 
    }

    public List<Order> getOrdersByUserId(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders;
    }
}
