package com.example.ll.batch_app.app.order.repository;

import com.example.ll.batch_app.app.order.entity.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Page<OrderItem> findAllByIdLessThan(long id, Pageable pageable);
    Page<OrderItem> findAllByIdBetween(long fromId, long toId, Pageable pageable);
}
