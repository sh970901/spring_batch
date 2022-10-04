package com.example.ll.batch_app.order.repository;

import com.example.ll.batch_app.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
