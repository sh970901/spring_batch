package com.example.ll.batch_app.cart.repository;

import com.example.ll.batch_app.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
