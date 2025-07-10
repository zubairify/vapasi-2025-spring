package com.tw.util;

public class ProductAlreadyExistException extends RuntimeException {
    public ProductAlreadyExistException(String message) {
        super(message);
    }

    public ProductAlreadyExistException() {
        super("Product already exists");
    }
}
