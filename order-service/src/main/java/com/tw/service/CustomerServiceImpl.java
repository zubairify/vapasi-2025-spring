package com.tw.service;

import com.tw.entity.Customer;
import com.tw.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Override
    public Customer addCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer findByCustId(int custId) {
        return null;
    }

    @Override
    public Customer authenticate(String mobile, String password) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
