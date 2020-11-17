package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    @ManyToMany
    private List<Product> products;

    @OneToOne
    private Person person;

    public ShoppingCart(Long id, Date date, List<Product> products, Person person) {
        this.id = id;
        this.date = date;
        this.products = products;
        this.person=person;
    }

    public ShoppingCart() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
