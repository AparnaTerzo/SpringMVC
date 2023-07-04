package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.Employee;

import java.util.stream.Collectors;

public class EmployeeMapper {
    public static Employee mapToEmployee(EmployeeDto employee) {
        Employee employeeDto = Employee.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .designation(employee.getDesignation())
                .mobile(employee.getMobile())
                .address(employee.getAddress())
                .department(employee.getDepartment())
                .build();
        return  employeeDto;
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .designation(employee.getDesignation())
                .mobile(employee.getMobile())
                .address(employee.getAddress())
                .department(employee.getDepartment())
                .build();
        return employeeDto;
    }

}
