package com.tw.service;

import com.tw.entity.Product;
import com.tw.repo.ProductRepository;
import com.tw.util.ProductNotFoundException;
import com.tw.util.ProductOutOfStockException;
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

    @Override
    public boolean updateStock(int code) {
        Product p = repo.findById(code).orElseThrow(() -> new ProductNotFoundException("Product not found by Code: " + code));
        if(p.getStock() == 0)
            throw new ProductOutOfStockException("Product out of stock code: " + code);
        p.setStock(p.getStock() - 1);
        return true;
    }
}
