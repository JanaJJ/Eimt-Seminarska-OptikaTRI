package com.example.demo.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String password;
    private boolean active;


    @ManyToMany(fetch=FetchType.EAGER)
    private List<Roles> roles;

    @OneToOne
    private ShoppingCart shoppingCart;


    public Person(Long id, String name, String surname, String address, String email, String password, Boolean active,List<Roles> roles, ShoppingCart shoppingCart) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.active=active;


        this.roles = roles;
        this.shoppingCart=shoppingCart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Roles> getRoles() {
        return (Set<Roles>) roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Person(Long id, String name, String surname, String address, List<Product> products) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;

    }

    public Person() {

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
