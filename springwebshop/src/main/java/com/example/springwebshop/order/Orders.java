package com.example.springwebshop.order;

import javax.persistence.*;
import java.time.LocalDate;

//Telling spring that this is going to be mapped to a table
@Entity
//Telling spring what the name of the table is
//It straight up broke when I named this order, probably because that's a mysql keyword
@Table
public class Orders {

    //Telling spring what the primary key is
    @Id
    //Telling spring how to generate the id value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long itemId;
    private LocalDate orderDate;

    public Orders() {}

    //Constructor for post requests
    public Orders(Long customerId, Long itemId) {
        this.customerId = customerId;
        this.itemId = itemId;
        this.orderDate = LocalDate.now();
    }

    //Constructor for the config file
    public Orders(Long customerId, Long itemId, LocalDate orderDate) {
        this.customerId = customerId;
        this.itemId = itemId;
        this.orderDate = orderDate;
    }

    //Generated value doesn't work when testing for some reason, so this is my damn solution
    //I tried to fix it for a long ass time, but could not find a solution, so I gave up and did this
    public Orders(Long id, Long customerId, Long itemId) {
        this.id = id;
        this.customerId = customerId;
        this.itemId = itemId;
        this.orderDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", itemId=" + itemId +
                ", orderDate=" + orderDate +
                '}';
    }
}
