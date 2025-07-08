package com.infosys.librarymanagement.repos;

import com.infosys.librarymanagement.beans.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepo extends JpaRepository<Books,Integer> {
    List<Books> findByAuthor(String author);
    List<Books> findByGenre(String genre);
    List<Books> findByPublicationYearGreaterThan(int year);
}
