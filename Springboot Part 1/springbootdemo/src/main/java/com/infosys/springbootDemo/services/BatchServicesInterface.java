package com.infosys.springbootDemo.services;

import com.infosys.springbootDemo.beans.Batches;

import java.util.List;
import java.util.Optional;

public interface BatchServicesInterface {
    void addBatch(Batches batch);
    void addMultipleBatches(List<Batches> batchesList);
    Optional<Batches> findBatchById(int batchId);
    void updateBatch(Batches batch);  // Add this line
    void deleteBatch(int batchId);
    List<Batches> getAllBatches();
    public List<Batches> findAllBatchesUsingQuery();
    Batches showBatchOnBasisOfStartDateAndName(String startDate, String batchName);


}



