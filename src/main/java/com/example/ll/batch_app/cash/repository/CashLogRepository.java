package com.example.ll.batch_app.cash.repository;

import com.example.ll.batch_app.cash.entity.CashLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashLogRepository extends JpaRepository<CashLog, Long> {
}
