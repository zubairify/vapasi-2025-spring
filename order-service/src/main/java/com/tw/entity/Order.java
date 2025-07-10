package com.tw.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private LocalDate orderDate;
    @Column(length = 15)
    private String payMode;
    private double platformFee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "code")
    private Product prod;

    @ManyToOne
    @JoinColumn(name = "custId")
    private Customer customer;
}
