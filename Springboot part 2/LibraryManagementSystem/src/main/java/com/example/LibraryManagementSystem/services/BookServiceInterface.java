package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.beans.Book;
import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {
    List<Book> getAllBooks();
    Book getBookById(int id);
    Book addBook(Book book);
    void deleteBook(int id);
    Book updateBook(Book book);
    Optional<Book> findBookById(int id);

}
