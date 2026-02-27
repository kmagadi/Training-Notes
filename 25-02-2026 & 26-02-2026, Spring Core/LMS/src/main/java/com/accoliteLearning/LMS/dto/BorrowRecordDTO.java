package com.accoliteLearning.LMS.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BorrowRecordDTO {
    @NotNull(message = "Book ID is required")
    private Integer bookId;

    @NotNull(message = "Member ID is required")
    private Integer memberId;
}