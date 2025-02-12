package com.datastructures.models;

import java.util.List;


public class Order {
    private String orderId;
    private User user;
    private List<Product> products;
    private double totalPrice;

    public Order(String orderId, User user, List<Product> products) {
        this.orderId = orderId;
        this.user = user;
        this.products = products;
        this.totalPrice = calculateTotal();
    }

    private double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Order{orderId='" + orderId + "', user=" + user.getName() +
                ", totalPrice=" + totalPrice + ", products=" + products + "}";
    }

    public String getOrderId() { return orderId; }
    public User getUser() { return user; }
    public List<Product> getProducts() { return products; }
    public double getTotalPrice() { return totalPrice; }
}
