package com.tw.service;

import com.tw.entity.Customer;
import com.tw.repo.CustomerRepository;
import com.tw.util.CustomerAlreadyExistException;
import com.tw.util.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Override
    public Customer addCustomer(Customer customer) {
        if(repo.existsById(customer.getCustId()))
            throw new CustomerAlreadyExistException("Customer already exists with ID: " + customer.getCustId());

        return repo.save(customer);
    }

    @Override
    public Customer findByCustId(int custId) {
        return repo.findById(custId).orElseThrow(
                ()->new CustomerNotFoundException("Customer not found: " + custId));
    }

    @Override
    public Customer authenticate(String mobile, String password) {
        return repo.findByMobileAndPassword(mobile, password).orElseThrow(
                () -> new CustomerNotFoundException("Invalid login credentials"));
    }

    @Override
    public List<Customer> findAll() {
        return repo.findAll();
    }
}
