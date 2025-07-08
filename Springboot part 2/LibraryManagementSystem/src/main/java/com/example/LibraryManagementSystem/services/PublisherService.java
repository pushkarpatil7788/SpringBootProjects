package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.beans.Publisher;
import com.example.LibraryManagementSystem.repos.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService implements PublisherServiceInterface {

    @Autowired
    private PublisherRepo publisherRepo;
    @Override
    public Optional<Publisher> findPublisherById(int id) {
        return publisherRepo.findById(id);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepo.findAll();
    }

    @Override
    public Publisher getPublisherById(int id) {
        return publisherRepo.findById(id).orElse(null);
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    @Override
    public void deletePublisher(int id) {
        publisherRepo.deleteById(id);
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepo.save(publisher);
    }
}
