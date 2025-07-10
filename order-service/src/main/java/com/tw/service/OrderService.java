package com.tw.service;

import com.tw.dto.OrderDto;
import com.tw.entity.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    Order placeOrder(OrderDto dto);

    List<Order> findAll();

    List<Order> ordersByCustomer(int custId);

    List<Order> ordersByPayMode(String payMode, int custId);

    List<Order> ordersWithDates(LocalDate start, LocalDate end, int custId);

    int totalOrderByCustomer(int custID);

    List<Order> orderForProduct(int code);
}
