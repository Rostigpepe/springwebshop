package com.example.springwebshop.item;

import javax.persistence.*;

//Telling spring that this is going to be mapped to a table
@Entity
//Telling spring what the name of the table is
@Table
public class Item {

    //Telling spring what the primary key is
    @Id
    //Telling spring how to generate the id value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;

    //To be ignored by the mapping, since this value is dependent on birthday, it's redundant to store
    @Transient
    private int priceClass;

    public Item() {}

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Item(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceClass() {
        return price / 10;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", priceClass=" + priceClass +
                '}';
    }
}
