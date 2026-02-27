package com.accoliteLearning.emp.controller;

import com.accoliteLearning.emp.model.Employee;
import com.accoliteLearning.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static javax.swing.text.html.parser.DTDConstants.ID;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public List< Employee > getEmp()
    {
        return empService.getAllEmployees();
    }

    @GetMapping("/{ID}")
    public Employee getEmpWithID(@PathVariable Integer ID) {
        return empService.getEmpWithID(ID);
    }

    @PostMapping
    public String addEmp(@RequestBody Employee employee) {
        empService.addEmployee(employee);
        return "Employee added successfully!";
    }
}