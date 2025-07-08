package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.beans.Book;
import com.example.LibraryManagementSystem.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceInterface {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }
    @Override
    public Optional<Book> findBookById(int id) {
        return bookRepo.findById(id);
    }


    @Override
    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }
}
