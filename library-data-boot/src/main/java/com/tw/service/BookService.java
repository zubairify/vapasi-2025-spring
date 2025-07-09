package com.tw.service;

import com.tw.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookService {

    Book save(Book book);

    Book findByIsbn(int isbn);

    List<Book> findAll();

    boolean deleteByIsbn(int isbn);

    List<Book> findByAuthor(String author);

    Book findByTitle(String title);

    List<Book> findByGenre(String genre);

    List<Book> findByPriceRange(double priceMin, double priceMax);
}
