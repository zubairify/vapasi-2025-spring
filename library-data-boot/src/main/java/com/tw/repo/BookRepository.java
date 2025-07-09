package com.tw.repo;

import com.tw.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByAuthor(String author);

    Optional<Book> findByTitle(String title);

    List<Book> findByGenre(String genre);

    @Query("FROM Book WHERE price BETWEEN :min AND :max")
    List<Book> findByPriceRange(@Param("min") double priceMin,
                                @Param("max") double priceMax);
}

