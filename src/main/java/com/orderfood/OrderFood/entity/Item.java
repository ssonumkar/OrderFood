package com.orderfood.OrderFood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

//    @ManyToOne
    private String itemType;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    @JsonIgnore
    private Order order;
}
