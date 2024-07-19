package com.orderfood.OrderFood.config;

import com.orderfood.OrderFood.entity.Order;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.producer.security.protocol}")
    private String securityProtocol;

    @Value("${spring.kafka.producer.sasl.jaas.config}")
    private String saslJaasConfig;

    @Value("${spring.kafka.producer.sasl.mechanism}")
    private String saslMechanism;

    @Value("${spring.kafka.producer.acks}")
    private String acks;

    @Bean
    public ProducerFactory<String, Order> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put("security.protocol", securityProtocol);
        props.put("sasl.jaas.config", saslJaasConfig);
        props.put("sasl.mechanism", saslMechanism);
        props.put("acks", acks);
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, Order> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}