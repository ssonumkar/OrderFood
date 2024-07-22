package com.orderfood.OrderFood.service;


import com.orderfood.OrderFood.entity.Order;
import com.orderfood.OrderFood.exception.PaymentNotCompletedException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(String topic, Order order) throws PaymentNotCompletedException {
        validateOrder(order);
        kafkaTemplate.send(topic, order);
    }

    private void validateOrder(Order order) throws PaymentNotCompletedException {
        if(!order.getPaymentStatus().equals("PAID")){
           throw new PaymentNotCompletedException("Please make the payment first");
        }
        //other validations
    }
}