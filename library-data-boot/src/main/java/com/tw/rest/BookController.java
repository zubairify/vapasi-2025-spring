package com.tw.rest;

import com.tw.entity.Book;
import com.tw.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        Book savedBook = service.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{isbn}", produces = "application/json")
    public ResponseEntity<Book> findByIsbn(@PathVariable int isbn) {
        Book book = service.findByIsbn(isbn);
        return new ResponseEntity<>(book, HttpStatus.FOUND);
    }

    @GetMapping(value = "/author/{author}", produces = "application/json")
    public ResponseEntity<List<Book>> findByAuthor(@PathVariable String author) {
        List<Book> books = service.findByAuthor(author);
        if(books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/title/{title}", produces = "application/json")
    public ResponseEntity<Book> findByTitle(@PathVariable String title) {
        Book book = service.findByTitle(title);
        return new ResponseEntity<>(book, HttpStatus.FOUND);
    }

    @GetMapping(value = "/genre/{genre}", produces = "application/json")
    public ResponseEntity<List<Book>> findByGenre(@PathVariable String genre) {
        List<Book> books = service.findByGenre(genre);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = service.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(value = "/price", produces = "application/json")
    public ResponseEntity<List<Book>> findByPriceRange(@RequestParam double min, @RequestParam double max) {
        List<Book> books = service.findByPriceRange(min, max);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> deleteByIsbn(@PathVariable int isbn) {
        if(service.deleteByIsbn(isbn))
            return new ResponseEntity<>("Book deleted", HttpStatus.OK);
        else
            return new ResponseEntity<>("Book not found",  HttpStatus.NOT_FOUND);
    }
}
