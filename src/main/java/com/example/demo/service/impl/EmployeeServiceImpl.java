package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import static com.example.demo.mapper.EmployeeMapper.mapToEmployeeDto;
import static com.example.demo.mapper.EmployeeMapper.mapToEmployee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEmployee(employeeDto);
        return employeeRepository.save(employee);
    }
    @Override
    public List<EmployeeDto> searchEmployees(String query) {
        List<Employee> employees= employeeRepository.searchEmployees(query);
        return employees.stream().map(employee -> mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto findEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        return mapToEmployeeDto(employee);
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEmployee(employeeDto);
        employeeRepository.save(employee);
    }


    @Override
    public void delete(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
