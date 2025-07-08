package com.example.LibraryManagementSystem.repos;

import com.example.LibraryManagementSystem.beans.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
