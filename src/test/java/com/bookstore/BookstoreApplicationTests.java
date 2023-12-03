package com.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;

@SpringBootTest
class BookstoreApplicationTests {
    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Test
    void shouldReturnBooks() throws Exception {
        when(bookRepository.findAll()).thenReturn(getBookList());
        assertEquals(2, bookService.getAllBooks().size());
    }

    private List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book();
        book1.setTitle("Java");

        Book book2 = new Book();
        book2.setTitle("C++");
        bookList.add(book1);
        bookList.add(book2);
        return bookList;
    }

    @Test
    void shouldReturnBook() throws Exception {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(new Book(1L, "JAVA", "Joe", 123456789L, "12-02-2-23", "Computing")));
        assertEquals(1L, bookService.getBook(1L).getId());
    }

    @Test
    void shouldAddBook() throws Exception {
        Book book = new Book();
        book.setTitle("Python");
        when(bookRepository.save(book)).thenReturn(book);
        assertEquals(book, bookService.addBook(book));
    }

    @Test
    void shouldDeleteBook() throws Exception {
        bookService.deleteBook(2L);
        verify(bookRepository).deleteById(2L);
    }

    @Test
    void shouldUpdateBook() throws Exception {
        Book bookUpdated = new Book();
        bookUpdated.setId(6L);
        bookUpdated.setTitle("Cloud Computing");
        when(bookRepository.findById(3L)).thenReturn(Optional.of(new Book(6L, "JAVA", null, null, null, null)));
        when(bookRepository.save(bookUpdated)).thenReturn(bookUpdated);
        assertEquals(bookUpdated, bookService.updateBook(6L, bookUpdated));
    }

}
