package com.orderfood.OrderFood.service;

import com.orderfood.OrderFood.entity.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class KafkaProducerServiceTest {

    @Mock
    private KafkaTemplate<String, Order> kafkaTemplate;

    @InjectMocks
    private KafkaProducerService kafkaProducerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendOrder() {
        String topic = "order-topic";
        Order order = new Order("123", "cust001", "PENDING", "2024-07-22T14:00:00", "rest001", null, 11.98, null, "CREDIT_CARD", "PAID");

        // Mock the ListenableFuture
        kafkaProducerService.sendOrder(topic, order);

        verify(kafkaTemplate, times(1)).send(topic, order);

    }
}