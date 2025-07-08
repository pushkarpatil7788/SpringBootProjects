package com.infosys.postgrerest.service;

import com.infosys.postgrerest.model.Book;

import java.util.List;

public interface BookService {
    String addBook(Book book);
    String updateBook(Long id, Book book);
    String deleteBook(Long id);
    Book getBookById(Long id);
    List<Book> getAllBooks();
}
