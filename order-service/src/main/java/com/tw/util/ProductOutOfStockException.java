package com.tw.util;

public class ProductOutOfStockException extends RuntimeException {
    public ProductOutOfStockException() {
        super("Product out of stock");
    }
    public ProductOutOfStockException(String message) {
        super(message);
    }
}
