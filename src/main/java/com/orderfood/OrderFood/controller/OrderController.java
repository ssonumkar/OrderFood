package com.orderfood.OrderFood.controller;


import com.orderfood.OrderFood.entity.Order;
import com.orderfood.OrderFood.service.KafkaProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final KafkaProducerService kafkaProducerService;

    public OrderController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        try {
            kafkaProducerService.sendOrder("test", order);
            return new ResponseEntity<>("Order sent to Kafka successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to send order to Kafka: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

