package com.infosys.springbootDemo.services;

import com.infosys.springbootDemo.beans.Batches;
import com.infosys.springbootDemo.repos.BatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchServices implements  BatchServicesInterface{
    @Autowired
    BatchRepo batchRepo;

    @Override
    public void addBatch(Batches batch) {
        batchRepo.save(batch);
    }

    @Override
    public void addMultipleBatches(List<Batches> batchesList) {
        Iterable<Batches> batchInfo =  batchRepo.saveAll(batchesList);

    }

    @Override
    public Optional<Batches> findBatchById(int batchId) {
        return batchRepo.findById(batchId);
    }

    @Override
    public void updateBatch(Batches batch) {
        batchRepo.save(batch);
    }
    @Override
    public void deleteBatch(int batchId) {
        batchRepo.deleteById(batchId);
    }

    @Override
    public List<Batches> getAllBatches() {
        return batchRepo.findAll();
    }

    @Override
    public List<Batches> findAllBatchesUsingQuery() {
        return batchRepo.showAllBatches();
    }

    @Override
    public Batches showBatchOnBasisOfStartDateAndName(String startDate, String batchName) {
        return batchRepo.showBatchOnBasisOfStartDateAndName(startDate, batchName);
    }


}