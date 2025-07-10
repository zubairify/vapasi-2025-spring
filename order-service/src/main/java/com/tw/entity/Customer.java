package com.tw.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    private int custId;
    @Column(length = 30)
    private String custName;
    @Column(length = 12)
    private String mobile;
    @Column(length = 50)
    private String address;
    @Column(length = 30)
    private String password;

    @JsonManagedReference("cust")
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Order> orders;
}
