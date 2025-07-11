package com.tw.test;

import com.tw.entity.Book;
import com.tw.repo.BookRepository;
import com.tw.service.BookServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBookService {
    @Mock
    private BookRepository repo;

    @InjectMocks
    private BookServiceImpl service;

    private Book book, book2;
    @BeforeEach
    public void setUp() {
        book = new Book(123, "Prosperity","James","Selfhelp",245);
        book2 = new Book(127, "Thinketh","James","Selfhelp",225);
    }

    @Test
    @Order(1)
    public void testSaveBook() {
        // precondition
        given(repo.save(book)).willReturn(book);
        // action
        Book savedBook = service.save(book);
        // verify
        assertNotNull(savedBook);
    }

    @Test
    @Order(2)
    public void testFindByIsbn() {
        // precondition
        given(repo.findById(123)).willReturn(Optional.of(book));
        // action
        Book result = service.findByIsbn(123);
        // verify
        assertNotNull(result);
    }

    @Test
    @Order(3)
    public void testFindAll() {
        // precondition
        given(repo.findAll()).willReturn(List.of(book, book2));
        // action
        List<Book> books = service.findAll();
        // verify
        assertEquals(2, books.size());
    }

    @Test
    @Order(4)
    public void testFindByTitle() {
        // precondition
        given(repo.findByTitle("Thinketh")).willReturn(Optional.of(book));
        // action
        Book book = service.findByTitle("Thinketh");
        // verify
        assertNotNull(book);
    }

    @Test
    @Order(5)
    public void testFindByAuthor() {
        // precondition
        given(repo.findByAuthor("James")).willReturn(List.of(book, book2));
        // action
        List<Book> books = repo.findByAuthor("James");
        // verify
        assertEquals(2, books.size());
    }

    @Test
    @Order(6)
    public void testFindByGenre() {
        // precondition
        given(repo.findByGenre("Selfhelp")).willReturn(List.of(book, book2));
        // action
        List<Book> books = repo.findByGenre("Selfhelp");
        // verify
        assertEquals(2, books.size());
    }

    @Test
    @Order(7)
    public void testFindByPriceRange() {
        // precondition
        given(repo.findByPriceRange(200, 300)).willReturn(List.of(book, book2));
        // action
        List<Book> books = repo.findByPriceRange(200,300);
        // verify
        assertEquals(2, books.size());
    }

    @Test
    @Order(8)
    public void testDelete() {
        // precondition
        willDoNothing().given(repo).deleteById(book.getIsbn());

        // action
        service.deleteByIsbn(book.getIsbn());

        // verify
        verify(repo, times(1)).deleteById(book.getIsbn());
    }
}
