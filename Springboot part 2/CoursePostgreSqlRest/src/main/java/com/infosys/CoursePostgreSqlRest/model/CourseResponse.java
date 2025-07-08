package com.infosys.CoursePostgreSqlRest.model;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private int statusCode;
    private String statusMsg;
    private LocalDate responseDate;
}
