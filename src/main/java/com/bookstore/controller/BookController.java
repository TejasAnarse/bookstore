package com.bookstore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    private List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    private Book getBook(@PathVariable("id") Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping("/book")
    private Book addBook(@RequestBody Book book) {
       return bookService.addBook(book);
    }

    @PutMapping("/book/{id}")
    private Book updateBook(@PathVariable("id") Long bookId, @RequestBody Book book) {
       return bookService.updateBook(bookId, book);
    }

    @DeleteMapping("/book/{id}")
    private void deleteBook(@PathVariable("id") Long bookId) {
        bookService.deleteBook(bookId);
    }
}
