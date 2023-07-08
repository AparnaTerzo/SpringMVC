package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> findAllEmployees();

    void updateEmployee(EmployeeDto employee);

    EmployeeDto findEmployeeById(Long employeeId);

    void delete(Long employeeId);
}
