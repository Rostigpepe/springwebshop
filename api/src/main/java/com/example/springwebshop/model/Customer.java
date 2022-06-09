package com.example.springwebshop.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

//Telling spring that this is going to be mapped to a table
@Entity
//Telling spring what the name of the table is
@Table
public class Customer {

    //Telling spring what the primary key is
    @Id
    //Telling spring how to generate the id value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private LocalDate birthday;

    //To be ignored by the mapping, since this value is dependent on birthday, it's redundant to store
    @Transient
    private int age;

    public Customer() {}

    public Customer(String name, String email, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    //Constructors with IDs are necessary since generated value does not seem to work with mock repositories
    public Customer(Long id, String name, String email, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                '}';
    }
}
