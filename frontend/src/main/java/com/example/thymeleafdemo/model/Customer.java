package com.example.thymeleafdemo.model;

import java.time.LocalDate;

public class Customer {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthday;
    private int age;

    public Customer() {
    }

    public Customer(Long id, String name, String email, LocalDate birthday, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }
}
