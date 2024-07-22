package com.orderfood.OrderFood.controller;


import com.orderfood.OrderFood.entity.Order;
import com.orderfood.OrderFood.exception.PaymentNotCompletedException;
import com.orderfood.OrderFood.service.KafkaProducerService;
import com.orderfood.OrderFood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final KafkaProducerService kafkaProducerService;
    private OrderService orderService;

    public OrderController(KafkaProducerService kafkaProducerService, OrderService orderService) {
        this.kafkaProducerService = kafkaProducerService;
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        try {
            kafkaProducerService.sendOrder("test", order);
            return new ResponseEntity<>("Order sent to Kafka successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to send order to Kafka: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PaymentNotCompletedException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable("orderId") String orderId) {
        Optional<Order> order = orderService.getOrderById(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}

