package com.tw.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.entity.Book;
import com.tw.rest.BookController;
import com.tw.service.BookService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBookController {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BookService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Book book, book2;
    @BeforeEach
    public void setUp() {
        book = new Book(123, "Prosperity","James","Selfhelp",245);
        book2 = new Book(127, "Thinketh","James","Selfhelp",225);
    }

    @Test
    @Order(1)
    public void testSaveBook() throws Exception {
        // precondition
        given(service.save(any(Book.class))).willReturn(book);
        // action
        ResultActions response = mockMvc.perform(post("/book/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)));
        // verify
        response.andExpect(status().isCreated());
    }

    @Test
    @Order(2)
    public void testFindByIsbn() throws Exception {
        // precondition
        given(service.findByIsbn(book.getIsbn())).willReturn(book);
        // action
        ResultActions response = mockMvc.perform(get("/book/{isbn}",  book.getIsbn()));
        // verify
        response.andExpect(status().isFound());
    }

    @Test
    @Order(3)
    public void testFindAll() throws Exception {
        // precondition
        List<Book> books = Arrays.asList(book,book2);
        given(service.findAll()).willReturn(books);
        // action
        ResultActions response = mockMvc.perform(get("/book/all"));
        // verify
        response.andExpect(status().isOk());
    }

    @Test
    @Order(4)
    public void testFindByTitle() throws Exception {
        // precondition
        given(service.findByTitle(book.getTitle())).willReturn(book);
        // action
        ResultActions response = mockMvc.perform(get("/book/title/{title}",  book.getTitle()));
        // verify
        response.andExpect(status().isFound());
    }

    @Test
    @Order(5)
    public void testFindByAuthor() throws Exception {
        // precondition
        List<Book> books = Arrays.asList(book,book2);
        given(service.findByAuthor(book.getAuthor())).willReturn(books);
        // action
        ResultActions response = mockMvc.perform(get("/book/author/{author}",  book.getAuthor()));
        // verify
        response.andExpect(status().isOk());
    }

    @Test
    @Order(6)
    public void testFindByGenre() throws Exception {
        // precondition
        List<Book> books = Arrays.asList(book,book2);
        given(service.findByGenre(book.getGenre())).willReturn(books);
        // action
        ResultActions response = mockMvc.perform(get("/book/genre/{genre}",  book.getGenre()));
        // verify
        response.andExpect(status().isOk());
    }

    @Test
    @Order(7)
    public void testFindByPriceRange() throws Exception {
        // precondition
        List<Book> books = Arrays.asList(book,book2);
        given(service.findByPriceRange(200, 300)).willReturn(books);
        // action
        ResultActions response = mockMvc.perform(get("/book/price").param("min", "200").param("max", "300"));
        // verify
        response.andExpect(status().isOk());
    }

    @Test
    @Order(8)
    public void testDelete() throws Exception {
        // precondition
        willDoNothing().given(service).deleteByIsbn(book.getIsbn());

        // action
        ResultActions response = mockMvc.perform(delete("/book/{isbn}",  book.getIsbn()));

        // verify
        response.andExpect(status().isOk());
    }
}
