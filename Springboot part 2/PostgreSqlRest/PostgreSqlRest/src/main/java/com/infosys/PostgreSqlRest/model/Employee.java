package com.infosys.PostgreSqlRest.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private String employeeId;

    private String employeeName;
    private String employeeAddress;
    private String employeePhoneNumber;
}
