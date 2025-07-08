package com.infosys.postgrerest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Integer statusCode;
    private String statusMessage;
    private LocalDate responseDate;
}
