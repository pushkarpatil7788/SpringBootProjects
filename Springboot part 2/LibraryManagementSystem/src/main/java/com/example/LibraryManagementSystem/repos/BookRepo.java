package com.example.LibraryManagementSystem.repos;

import com.example.LibraryManagementSystem.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {

}
