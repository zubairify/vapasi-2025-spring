package com.tw.rest;

import com.tw.dto.OrderDto;
import com.tw.entity.Order;
import com.tw.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping(value = "/place", produces = "application/json")
    public ResponseEntity<Order> placeOrder(@RequestBody OrderDto dto) {
        Order order = service.placeOrder(dto);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = service.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{custId}", produces = "application/json")
    public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable int custId) {
        List<Order> orders = service.ordersByCustomer(custId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/mode", produces = "application/json")
    public ResponseEntity<List<Order>> getOrdersByMode(@RequestParam String mode, @RequestParam int custId) {
        List<Order> orders = service.ordersByPayMode(mode, custId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/dates", produces = "application/json")
    public ResponseEntity<List<Order>> getOrdersByDate(@RequestParam LocalDate start, @RequestParam LocalDate end, @RequestParam int custId) {
        List<Order> orders = service.ordersWithDates(start, end, custId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/product/{code}", produces = "application/json")
    public ResponseEntity<List<Order>> getOrdersByProduct(@PathVariable int code) {
        List<Order> orders = service.orderForProduct(code);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/total", produces = "application/json")
    public ResponseEntity<Integer> getTotalOrdersByCustomer(@RequestParam int custId) {
        Integer total = service.totalOrderByCustomer(custId);
        return new ResponseEntity<>(total, HttpStatus.OK);
    }
}
