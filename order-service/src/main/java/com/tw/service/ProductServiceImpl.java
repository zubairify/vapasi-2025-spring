package com.tw.service;

import com.tw.entity.Product;
import com.tw.repo.ProductRepository;
import com.tw.util.ProductAlreadyExistException;
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
        if(repo.existsById(product.getCode()))
            throw new ProductAlreadyExistException("Product already exist with Code: " + product.getCode());

        return repo.save(product);
    }

    @Override
    public Product findByCode(int code) {
        return repo.findById(code).orElseThrow(
                () -> new ProductNotFoundException("Product with code " + code + " not found")
        );
    }

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Product> outOfStock() {
        return repo.findOutOfStock();
    }

    @Override
    public boolean updateStock(int code) {
        Product p = repo.findById(code).orElseThrow(
                () -> new ProductNotFoundException("Product not found by Code: " + code));
        if(p.getStock() == 0)
            throw new ProductOutOfStockException("Product out of stock code: " + code);
        p.setStock(p.getStock() - 1);
        return true;
    }
}
