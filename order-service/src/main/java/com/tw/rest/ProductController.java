package com.tw.rest;

import com.tw.entity.Product;
import com.tw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product prod = service.addProduct(product);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @GetMapping(value = "/{code}", produces = "application/json")
    public ResponseEntity<Product> get(@PathVariable int code) {
        Product prod = service.findByCode(code);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = service.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/stock", produces = "application/json")
    public ResponseEntity<List<Product>> getOutOfStock() {
        List<Product> products = service.outOfStock();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}
