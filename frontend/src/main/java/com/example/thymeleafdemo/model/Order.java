package com.example.thymeleafdemo.model;

import java.time.LocalDate;

public class Order {

    private Long id;
    private Long customerId;
    private Long itemId;
    private LocalDate orderDate;

    public Order() {
    }

    public Order(Long id, Long customerId, Long itemId, LocalDate orderDate) {
        this.id = id;
        this.customerId = customerId;
        this.itemId = itemId;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getItemId() {
        return itemId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
