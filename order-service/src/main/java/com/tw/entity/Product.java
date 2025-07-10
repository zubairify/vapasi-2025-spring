package com.tw.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Product {
    @Id
    private int code;
    @Column(length = 30)
    private String name;
    private double price;
    private int stock;

    @JsonManagedReference
    @OneToMany(mappedBy = "prod")
    private List<Order> orders;
}
