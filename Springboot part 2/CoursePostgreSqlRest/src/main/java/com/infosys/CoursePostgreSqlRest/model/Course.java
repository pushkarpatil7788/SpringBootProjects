package com.infosys.CoursePostgreSqlRest.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private String courseId;

    private String courseName;
    private String instructor;
    private Integer duration;
}
