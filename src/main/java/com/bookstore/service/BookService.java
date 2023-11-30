package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Book;

public interface BookService {
    List<Book> getAllBooks();

    Book getBook(Long bookId);

    Book addBook(Book book);

    Book updateBook(Long id, Book book);

    void deleteBook(Long bookId);
}
