package com.orderfood.OrderFood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderFoodApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner run(KafkaProducerService kafkaProducerService) {
//		return args -> {
//			Address deliveryAddress = new Address(
//					"123 Main St",
//					"Springfield",
//					"IL",
//					"62701"
//			);
//
//			// Create sample items
//			List<Item> items = Arrays.asList(
//					new Item( "Pizza Margherita", ItemType.valueOf("BURGER"), 2, 12.99)
//			);
//
//			// Create sample order
//			Order order = new Order(
//					"ORD123456",
//					"CUST7890",
//					"Pending",
//					"2024-07-19",
//					"REST123",
//					items,
//					31.97,
//					deliveryAddress,
//					"Credit Card",
//					"Paid"
//			);
////			Order order = new Order("12345", "John Doe", "Pizza", 2, 29.99);
//			kafkaProducerService.sendOrder("test", order);
//		};
//	}
}
