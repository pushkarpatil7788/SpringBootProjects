package com.infosys.config;

import com.infosys.service.Book;
import com.infosys.service.LibraryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Book book() {
        Book book = new Book();
        book.setTitle("To Kill a Mockingbird");
        book.setAuthor("Harper Lee");
        return book;
    }

    @Bean
    public LibraryService libraryService() {
        LibraryService service = new LibraryService();
        service.setBook(book());  // setter injection
        return service;
    }
}
