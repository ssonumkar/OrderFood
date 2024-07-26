package com.orderfood.OrderFood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    private String orderId;
    private String customerId;
    private String restaurantId;
    private String orderDate;
    private String status;

    @OneToMany(mappedBy = "order")
    private Set<Item> items;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address deliveryAddress;

    private double totalAmount;
    private String paymentMethod;
    private String paymentStatus;
}
