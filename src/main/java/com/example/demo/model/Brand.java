package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "brand")
    List<Product> products;

    public Brand(Long id, String name,String description, List<Product> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = products;
    }

    public Brand() {

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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }
}
