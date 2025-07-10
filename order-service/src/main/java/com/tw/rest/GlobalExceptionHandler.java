package com.tw.rest;

import com.tw.util.CustomerNotFoundException;
import com.tw.util.InvalidCredentialsException;
import com.tw.util.ProductNotFoundException;
import com.tw.util.ProductOutOfStockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<?> handleInvalidCredentials(InvalidCredentialsException exception) {
        ErrorResponse error =
                ErrorResponse.create(exception , HttpStatus.BAD_REQUEST , exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> handleCustomerNotFound(CustomerNotFoundException exception) {
        ErrorResponse error =
                ErrorResponse.create(exception , HttpStatus.BAD_REQUEST , exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFound(ProductNotFoundException exception) {
        ErrorResponse error =
                ErrorResponse.create(exception , HttpStatus.BAD_REQUEST , exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductOutOfStockException.class)
    public ResponseEntity<?> handleProductOutOfStock(ProductOutOfStockException exception) {
        ErrorResponse error =
                ErrorResponse.create(exception , HttpStatus.BAD_REQUEST , exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
