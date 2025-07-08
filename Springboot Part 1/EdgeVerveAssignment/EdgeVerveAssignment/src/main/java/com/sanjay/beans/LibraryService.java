package com.sanjay.beans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryService {
    private List<Book> books = new ArrayList<>();
    private int noOfMembers;

    public List<Book> getBooks() {
        return books;
    }

    @Autowired
    public void setBook(Book book) {
        books.add(book);
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<String> getAllBooksName(){
        List<String> bookNames = new ArrayList<>();
        for (Book book: books
             ) {
            bookNames.add(book.getBookName());
        }
        return bookNames;
    }

    public int getNoOfMembers() {
        return noOfMembers;
    }

    public void setNoOfMembers(int noOfMembers) {
        this.noOfMembers = noOfMembers;
    }
}
