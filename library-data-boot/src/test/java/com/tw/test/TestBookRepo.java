package com.tw.test;

import com.tw.entity.Book;
import com.tw.repo.BookRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBookRepo {

    @Autowired
    private BookRepository repo;

    @Test
    public void testFindByIsbn() {
        Optional<Book> entity = repo.findById(4325);
        assertTrue(entity.isPresent());
        assertEquals(entity.get().getTitle(), "The Alchemist");
    }

    @Test
    @DisplayName("Test 1:Save Book Test")
    @Order(1)
    public void testSave() {
        Book book = new Book(127, "Thinketh","James","Motivational",225);

        Book savedEntity = repo.save(book);
        assertNotNull(savedEntity);
    }

    @Test
    @Order(2)
    public void testFindById() {
        Book book = repo.findById(127).get();

        assertNotNull(book);
    }

    @Test
    @Order(3)
    public void testFindAll() {
        List<Book> books = repo.findAll();
        assertTrue(books.size() > 0);
    }

    @Test
    @Order(4)
    public void testFindByTitle() {
        Book book = repo.findByTitle("Thinketh").get();

        assertNotNull(book);
    }

    @Test
    @Order(5)
    public void testFindByAuthor() {
        List<Book> books = repo.findByAuthor("Rowling");
        assertTrue(books.size() > 0);
    }

    @Test
    @Order(6)
    public void testFindByGenre() {
        List<Book> books = repo.findByGenre("Fiction");
        assertTrue(books.size() > 0);
    }

    @Test
    @Order(7)
    public void testFindByPriceRange() {
        List<Book> books = repo.findByPriceRange(200,300);
        assertTrue(books.size() > 0);
    }

    @Test
    @Order(8)
    public void testDelete() {
        repo.deleteById(127);
        Optional<Book> book = repo.findById(127);
        assertTrue(book.isEmpty());
    }
}
