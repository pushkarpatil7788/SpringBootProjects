package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.beans.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorServiceInterface {
    Optional<Author> findAuthorById(int id);
    List<Author> getAllAuthors();
    Author getAuthorById(int id);
    Author addAuthor(Author author);
    void deleteAuthor(int id);
    Author updateAuthor(Author author);
}
