package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.beans.Author;
import com.example.LibraryManagementSystem.repos.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements AuthorServiceInterface {

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public Optional<Author> findAuthorById(int id) {
        return authorRepo.findById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepo.findById(id).orElse(null);
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public void deleteAuthor(int id) {
        authorRepo.deleteById(id);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepo.save(author);
    }
}
