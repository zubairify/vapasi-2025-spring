package com.tw.service;

import com.tw.entity.Book;
import com.tw.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repo;

    @Override
    public Book save(Book book) {
        return repo.save(book);
    }

    @Override
    public Book findByIsbn(int isbn) {
        return repo.findById(isbn).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean deleteByIsbn(int isbn) {
        repo.deleteById(isbn);
        return true;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return repo.findByAuthor(author);
    }

    @Override
    public Book findByTitle(String title) {
        return repo.findByTitle(title);
    }

    @Override
    public List<Book> findByGenre(String genre) {
        return repo.findByGenre(genre);
    }

    @Override
    public List<Book> findByPriceRange(double priceMin, double priceMax) {
        return repo.findByPriceRange(priceMin, priceMax);
    }
}
