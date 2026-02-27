package com.accoliteLearning.LMS.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookDTO {
    @NotBlank(message = "Book name cannot be empty")
    private String bookName;
    @NotBlank(message = "Genre is required")
    private String genre;
    @NotBlank(message = "Author is required")
    private String author;
}