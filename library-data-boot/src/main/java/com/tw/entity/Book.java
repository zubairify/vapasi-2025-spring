package com.tw.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    private int isbn;
    @Column(length = 30)
    private String title;
    @Column(length = 30)
    private String author;
    @Column(length = 15)
    private String genre;
    private double price;
}
