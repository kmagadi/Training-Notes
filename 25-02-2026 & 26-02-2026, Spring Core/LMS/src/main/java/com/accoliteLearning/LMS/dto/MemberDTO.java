package com.accoliteLearning.LMS.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberDTO {
    @NotBlank(message = "Member name is required")
    private String name;
}