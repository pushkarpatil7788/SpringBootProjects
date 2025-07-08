package com.infosys.springbootDemo.beans;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_Laptop")
public class Laptops {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int laptopId;
    @NotBlank(message = "Model name can not be empty")
    private String laptopName;

    public Laptops(){}

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public Laptops(String laptopName, int laptopId) {
        this.laptopName = laptopName;
        this.laptopId = laptopId;
    }

    @Override
    public String toString() {
        return "Laptops{" +
                "laptopId=" + laptopId +
                ", laptopName='" + laptopName + '\'' +
                '}';
    }
}
