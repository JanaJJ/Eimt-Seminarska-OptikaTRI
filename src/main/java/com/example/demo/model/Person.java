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
    private boolean status;


    @ManyToMany(fetch=FetchType.EAGER)
    private List<Roles> roles;

    @OneToOne
    private ShoppingCart shoppingCart;


    public Person(Long id, String name, String surname, String address, String email, String password, Boolean status,List<Roles> roles, ShoppingCart shoppingCart) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.status=status;


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

    public List<Roles> getRoles() {
        return roles;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
