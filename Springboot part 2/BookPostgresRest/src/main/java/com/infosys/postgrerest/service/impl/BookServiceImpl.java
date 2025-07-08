package com.infosys.postgrerest.service.impl;

import com.infosys.postgrerest.Exception.BookException;
import com.infosys.postgrerest.model.Book;
import com.infosys.postgrerest.repository.BookRepository;
import com.infosys.postgrerest.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String addBook(Book book) {
        bookRepository.save(book);
        return "Book successfully added";
    }

    @Override
    public String updateBook(Long id, Book book) {
        if (bookRepository.findById(id).isEmpty()) {
            throw new BookException(id);
        }
        book.setId(id); // Ensure ID is preserved
        bookRepository.save(book);
        return "Book successfully updated";
    }

    @Override
    public String deleteBook(Long id) {
        if (bookRepository.findById(id).isEmpty()) {
            throw new BookException(id);
        }
        bookRepository.deleteById(id);
        return "Book successfully deleted";
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookException(id));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
