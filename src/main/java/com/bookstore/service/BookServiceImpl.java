package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return book.orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Optional<Book> bookData = bookRepository.findById(id);
        if(bookData.isPresent()) {
            Book bookInfo = bookData.get();
            bookInfo.setGenre(book.getGenre());
            bookInfo.setAuthor(book.getAuthor());
            bookInfo.setIsbn(book.getIsbn());
            bookInfo.setPublishedDate(book.getPublishedDate());
            bookRepository.save(bookInfo);
        }
        return book;
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
