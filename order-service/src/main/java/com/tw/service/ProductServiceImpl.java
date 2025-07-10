package com.tw.service;

import com.tw.entity.Product;
import com.tw.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product findByCode(int code) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public List<Product> outOfStock() {
        return List.of();
    }
}
