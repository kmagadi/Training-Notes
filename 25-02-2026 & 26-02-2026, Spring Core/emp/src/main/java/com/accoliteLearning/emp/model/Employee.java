package com.accoliteLearning.emp.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    public Integer id;
    private Integer Salary;
    private String department;
}