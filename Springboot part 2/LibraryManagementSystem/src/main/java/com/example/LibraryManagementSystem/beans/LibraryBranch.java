package com.example.LibraryManagementSystem.beans;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class LibraryBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int libraryBranchid;

    private String libraryBranchName;

    @ManyToMany(mappedBy = "branches")
    private List<Book> books = new ArrayList<>();

    public LibraryBranch() {
    }

    public LibraryBranch(int libraryBranchid, String libraryBranchName, List<Book> books) {
        this.libraryBranchid = libraryBranchid;
        this.libraryBranchName = libraryBranchName;
        this.books = books;
    }

    public int getLibraryBranchid() {
        return libraryBranchid;
    }

    public void setLibraryBranchid(int libraryBranchid) {
        this.libraryBranchid = libraryBranchid;
    }

    public String getLibraryBranchName() {
        return libraryBranchName;
    }

    public void setLibraryBranchName(String libraryBranchName) {
        this.libraryBranchName = libraryBranchName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "LibraryBranch{" +
                "libraryBranchid=" + libraryBranchid +
                ", libraryBranchName='" + libraryBranchName + '\'' +
                '}';
    }
}
