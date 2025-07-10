package com.tw.service;

import com.tw.dto.OrderDto;
import com.tw.entity.Customer;
import com.tw.entity.Order;
import com.tw.entity.Product;
import com.tw.repo.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Order placeOrder(OrderDto dto) {
        Order order = new Order();
        Customer customer = customerService.findByCustId(dto.getCustId());
        Product product = productService.findByCode(dto.getCode());
        order.setCustomer(customer);
        order.setProd(product);
        order.setPayMode(dto.getPayMode());
        order.setOrderDate(LocalDate.now());
        double pf = product.getPrice() * 0.02;
        order.setPlatformFee(pf);
        productService.updateStock(product.getCode());
        return orderRepo.save(order);
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
