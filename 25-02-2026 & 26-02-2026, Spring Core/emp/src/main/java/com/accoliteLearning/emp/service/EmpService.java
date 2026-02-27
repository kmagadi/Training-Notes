package com.accoliteLearning.emp.service;

import com.accoliteLearning.emp.model.Employee;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class EmpService {
    private List<Employee> empList = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return empList;
    }

    public Employee getEmpWithID( Integer ID )
    {
        for( Employee emp : empList )
        {
            if( emp.id.equals(ID))
            {
                return emp;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        empList.add(employee);
    }
}