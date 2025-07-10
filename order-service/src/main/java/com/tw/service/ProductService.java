package com.tw.service;

import com.tw.entity.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    Product findByCode(int code);

    List<Product> findAll();

    List<Product> outOfStock();
}
