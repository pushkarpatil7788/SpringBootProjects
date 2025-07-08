package com.example.LibraryManagementSystem.beans;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisherId;

    private String publisherName;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();


    public Publisher() {
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Publisher(int publisherId, String publisherName, List<Book> books) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", publisherName='" + publisherName + '\'' +
                // DO NOT include 'books' here to avoid lazy loading issues
                '}';
    }

}
