package com.tw.rest;

import com.tw.entity.Customer;
import com.tw.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        Customer cust = service.addCustomer(customer);
        return new ResponseEntity<Customer>(cust, HttpStatus.OK);
    }

    @GetMapping(value = "/{custId}", produces = "application/json")
    public ResponseEntity<Customer> get(@PathVariable int custId) {
        Customer cust = service.findByCustId(custId);
        return new ResponseEntity<>(cust, HttpStatus.OK);
    }

    @GetMapping(value = "/login", produces = "application/json")
    public ResponseEntity<Customer> login(@RequestParam String mobile, @RequestParam String password) {
        Customer cust = service.authenticate(mobile, password);
        return new ResponseEntity<>(cust, HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> customers = service.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
