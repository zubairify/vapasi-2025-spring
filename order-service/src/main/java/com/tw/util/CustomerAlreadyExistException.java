package com.tw.util;

public class CustomerAlreadyExistException extends RuntimeException {
    public CustomerAlreadyExistException(String message) {
        super(message);
    }
    public CustomerAlreadyExistException() {
        super("Customer already exists");
    }
}
