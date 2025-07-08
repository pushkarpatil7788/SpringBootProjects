package com.example.LibraryManagementSystem.beans;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String bookTitle;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "book_branch",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "branch_id")
    )
    private List<LibraryBranch> branches = new ArrayList<>();

    public Book(String bookTitle, Publisher publisher, List<Author> authors, List<LibraryBranch> branches) {
        this.bookTitle = bookTitle;
        this.publisher = publisher;
        this.authors = authors;
        this.branches = branches;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<LibraryBranch> getBranches() {
        return branches;
    }

    public void setBranches(List<LibraryBranch> branches) {
        this.branches = branches;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", publisher=" + publisher.getPublisherName() +
                '}';
    }

}
