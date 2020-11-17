package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    public Roles(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Roles() {

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

}
