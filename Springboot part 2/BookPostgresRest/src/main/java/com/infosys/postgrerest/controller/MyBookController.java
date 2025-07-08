package com.infosys.postgrerest.controller;

import com.infosys.postgrerest.model.Book;
import com.infosys.postgrerest.model.BookResponse;
import com.infosys.postgrerest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/book")
public class MyBookController {

    private final BookService bookService;

    public MyBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String home() {
        return "Welcome to Spring Boot Book REST API";
    }

    @GetMapping("/welcome")
    public BookResponse welcome() {
        BookResponse response = new BookResponse();
        response.setStatusCode(200);
        response.setStatusMessage("Welcome to Book REST Service");
        response.setResponseDate(LocalDate.now());
        return response;
    }

    @PostMapping("/addbook")
    public BookResponse addBook(@RequestBody Book book) {
        bookService.addBook(book);
        BookResponse response = new BookResponse();
        response.setStatusCode(200);
        response.setStatusMessage("Book Added Successfully");
        response.setResponseDate(LocalDate.now());
        return response;
    }

    @PostMapping("/newbook")
    public ResponseEntity<BookResponse> addNewBook(@RequestBody Book book) {
        bookService.addBook(book);
        BookResponse response = new BookResponse();
        response.setStatusCode(201);
        response.setStatusMessage("Book Added Successfully with ResponseEntity");
        response.setResponseDate(LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("X-App-Header", "SpringBookAPI")
                .body(response);
    }

    @GetMapping("/search")
    public Book getBookById(@RequestParam Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("/update")
    public BookResponse updateBook(@RequestBody Book book) {
        bookService.updateBook(book.getId(), book);
        BookResponse response = new BookResponse();
        response.setStatusCode(200);
        response.setStatusMessage("Book Updated Successfully");
        response.setResponseDate(LocalDate.now());
        return response;
    }


    @DeleteMapping("/delete")
    public BookResponse deleteBook(@RequestParam Long id) {
        bookService.deleteBook(id);
        BookResponse response = new BookResponse();
        response.setStatusCode(200);
        response.setStatusMessage("Book Deleted Successfully");
        response.setResponseDate(LocalDate.now());
        return response;
    }
}
