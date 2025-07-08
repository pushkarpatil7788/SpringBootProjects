package com.infosys.springbootDemo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@Entity
@Table(name ="tb_batches")
public class Batches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Size(min = 1, message = "Batch Id must 3 char")
    private  int batchId;

    @NotBlank(message = "Batch name can not be empty")
    private  String batchName;
    @NotBlank(message = "Batch Start Date can not be empty")
    private    String batchStartDate;
    private    String batchEndDate;

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchStartDate() {
        return batchStartDate;
    }

    public void setBatchStartDate(String batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    public String getBatchEndDate() {
        return batchEndDate;
    }

    public void setBatchEndDate(String batchEndDate) {
        this.batchEndDate = batchEndDate;
    }

    @Override
    public String toString() {
        return "Batches{" +
                "batchId=" + batchId +
                ", batchName='" + batchName + '\'' +
                ", batchStartDate='" + batchStartDate + '\'' +
                ", batchEndDate='" + batchEndDate + '\'' +
                '}';
    }

}