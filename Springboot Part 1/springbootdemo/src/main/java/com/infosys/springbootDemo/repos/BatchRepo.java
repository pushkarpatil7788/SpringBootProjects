package com.infosys.springbootDemo.repos;

import com.infosys.springbootDemo.beans.Batches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BatchRepo extends JpaRepository<Batches, Integer> {
    public List<Batches> findByBatchName(String batchName);

    public List<Batches> findByBatchStartDateAndBatchEndDate(String startDate, String endDate);

    @Query("SELECT batch FROM Batches batch")
    public List<Batches> showAllBatches();

    @Query("SELECT batch FROM Batches batch WHERE batch.batchStartDate = :bsd AND batch.batchName = :bn")
    public Batches showBatchOnBasisOfStartDateAndName(@Param("bsd") String startDate, @Param("bn") String batchName);
}
