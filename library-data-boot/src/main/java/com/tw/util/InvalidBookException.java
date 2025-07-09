package com.tw.util;

public class InvalidBookException extends RuntimeException {
    public InvalidBookException() {
    }

    public InvalidBookException(String message) {
        super(message);
    }
}
