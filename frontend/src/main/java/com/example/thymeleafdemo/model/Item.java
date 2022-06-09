package com.example.thymeleafdemo.model;

public class Item {

    private Long id;
    private String name;
    private int price;
    private int priceClass;


    public Item() {
    }

    public Item(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceClass = price/10;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPriceClass() {
        return priceClass;
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
