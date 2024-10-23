package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
