package com.tw.repo;

import com.tw.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,Integer> {

    List<Product> findByCategory(String category);
}
