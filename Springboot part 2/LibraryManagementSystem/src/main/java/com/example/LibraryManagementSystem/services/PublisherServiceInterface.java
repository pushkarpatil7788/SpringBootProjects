package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.beans.Publisher;
import java.util.List;
import java.util.Optional;

public interface PublisherServiceInterface {
    Optional<Publisher> findPublisherById(int id);
    List<Publisher> getAllPublishers();
    Publisher getPublisherById(int id);
    Publisher addPublisher(Publisher publisher);
    void deletePublisher(int id);
    Publisher updatePublisher(Publisher publisher);
}
