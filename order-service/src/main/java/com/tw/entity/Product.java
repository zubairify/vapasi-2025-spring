package com.tw.entity;

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

    @OneToMany(mappedBy = "prod")
    private List<Order> orders;
}
