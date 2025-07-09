package com.tw.rest;

import com.tw.entity.Book;
import com.tw.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Book save(@RequestBody Book book) {
        return service.save(book);
    }

    @GetMapping(value = "/{isbn}", produces = "application/json")
    public Book findByIsbn(@PathVariable int isbn) {
        return service.findByIsbn(isbn);
    }

    @GetMapping(value = "/author/{author}", produces = "application/json")
    public List<Book> findByAuthor(@PathVariable String author) {
        return service.findByAuthor(author);
    }

    @GetMapping(value = "/title/{title}", produces = "application/json")
    public Book findByTitle(@PathVariable String title) {
        return service.findByTitle(title);
    }

    @GetMapping(value = "/genre/{genre}", produces = "application/json")
    public List<Book> findByGenre(@PathVariable String genre) {
        return service.findByGenre(genre);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<Book> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/price", produces = "application/json")
    public List<Book> findByPriceRange(@RequestParam double min, @RequestParam double max) {
        return service.findByPriceRange(min, max);
    }

    @DeleteMapping("/{isbn}")
    public String deleteByIsbn(@PathVariable int isbn) {
        if(service.deleteByIsbn(isbn))
            return "Book deleted";
        else
            return "Book not found";
    }
}
