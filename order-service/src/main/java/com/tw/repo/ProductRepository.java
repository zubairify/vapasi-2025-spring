package com.tw.repo;

import com.tw.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("FROM Product WHERE stock=0")
    List<Product> findOutOfStock();
}
