package com.tw.service;

import com.tw.dto.OrderDto;
import com.tw.entity.Order;
import com.tw.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Override
    public Order placeOrder(OrderDto dto) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }

    @Override
    public List<Order> ordersByCustomer(int custId) {
        return List.of();
    }

    @Override
    public List<Order> ordersByPayMode(String payMode, int custId) {
        return List.of();
    }

    @Override
    public List<Order> ordersWithDates(LocalDate start, LocalDate end, int custId) {
        return List.of();
    }

    @Override
    public int totalOrderByCustomer(int custID) {
        return 0;
    }

    @Override
    public List<Order> orderForProduct(int code) {
        return List.of();
    }
}
