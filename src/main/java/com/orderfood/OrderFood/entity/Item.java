package com.orderfood.OrderFood.entity;

public class Item {
    private String name;
    private ItemType itemType;
    private int quantity;
    private double price;

    public Item(String name, ItemType itemType, int quantity, double price) {
        this.name = name;
        this.itemType = itemType;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
// Getters and setters

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
