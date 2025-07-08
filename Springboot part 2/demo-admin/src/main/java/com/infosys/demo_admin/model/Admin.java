package com.infosys.demo_admin.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admininfo1")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    @NotEmpty(message = "Name cannot be empty")
    private String adminName;
    @NotEmpty(message = "password is required")
    @Size(min = 0,max = 16,message = "pass word must be greater than 8 and smaller than 16")
    private String adminPassword;
}