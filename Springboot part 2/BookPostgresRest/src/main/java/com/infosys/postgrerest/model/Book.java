package com.infosys.postgrerest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mybook")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Book title can't be empty")
    @Size(min = 3, message = "Book title should be at least 3 characters long")
    private String title;

    @NotBlank(message = "Author name can't be empty")
    private String author;

    @NotNull(message = "Price is required")
    private Double price;

}
