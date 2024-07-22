package com.orderfood.OrderFood.dao;

import com.orderfood.OrderFood.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Retryable(maxAttempts = 3)
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByOrderId(String orderId);
}